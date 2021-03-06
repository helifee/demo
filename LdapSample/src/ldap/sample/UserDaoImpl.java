package ldap.sample;

import java.util.List;

import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.CollectingAuthenticationErrorCallback;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

public class UserDaoImpl implements UserDao {
	
	private LdapTemplate ldapTemplate;

	/**
	 * bind
	 */
	@Override
	public void create(User user) {
		ldapTemplate.bind(buildDn(user), null, buildAttributes(user));
	}
	
	private Attributes buildAttributes(User user) {
		Attributes attr = new BasicAttributes();
		attr.put("objectClass", "ESB-User");
		attr.put("uid", user.getId());
		attr.put("cn", user.getName());
		attr.put("userPassword", user.getPassword());
		attr.put("email", user.getEmail());
		return attr;
	}
	
	private Name buildDn(User user) {
		DistinguishedName dn = new DistinguishedName();
		if(user != null) {
			dn.add("ou", "ESB");
			dn.add("ou", "User");
			dn.add("cn", user.getName());
		}
		return dn;
	}

	/**
	 * rebind
	 */
	@Override
	public void update(User user) {
		Name dn = buildDn(user);
		Attributes attributes = buildAttributes(user);
		ldapTemplate.rebind(dn, null, attributes);
	}

	/**
	 * unbind
	 */
	@Override
	public void delete(User user) {
		
		Name dn = buildDn(user);
//		ldapTemplate.unbind("cn=XXX");
		ldapTemplate.unbind(dn);
	}

	/**
	 * query
	 */
	@SuppressWarnings("unchecked")
	@Override
		public User getUserByName(final String name) {
			AndFilter filter = new AndFilter();
			filter.and(new EqualsFilter("objectclass", "ESB-User"));
			filter.and(new EqualsFilter("cn", name));
			
			List<User> users = ldapTemplate.search("", filter.toString(), new AttributesMapper() {
	
				@Override
				public Object mapFromAttributes(Attributes attributes)
						throws NamingException {
					User user = new User();
					user.setId(name);
					user.setName((String)attributes.get("cn").get());
//					user.setPassword((String)attributes.get("userPassword").get()); TODO
					user.setEmail((String)attributes.get("email").get());
					return user;
				}
				
			});
			if(users.isEmpty()) {
				return null;
			} else {
				return users.get(0);
			}
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllUserNames() {
		return ldapTemplate.search("", "(objectclass=ESB-User)",
				new AttributesMapper() {
					public Object mapFromAttributes(Attributes attrs)
							throws NamingException {
						return attrs.get("cn").get();
					}
				});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		EqualsFilter filter = new EqualsFilter("objectclass", "ESB-User");
		return ldapTemplate.search(DistinguishedName.EMPTY_PATH, filter.toString(), new AttributesMapper() {

			@Override
			public User mapFromAttributes(Attributes attributes)
					throws NamingException {
				User user = new User();
				user.setId((String)attributes.get("uid").get());
				user.setName((String)attributes.get("cn").get());
//				user.setPassword((String)attributes.get("userPassword").get()); TODO
				user.setEmail((String)attributes.get("email").get());
				return user;
			}
			
		});
	}

	public LdapTemplate getLdapTemplate() {
		return ldapTemplate;
	}

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}
	
	@Override
	public boolean authenticate(String userName, String password) throws Exception {
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "ESB-User"));
		filter.and(new EqualsFilter("cn", userName));
		
		//��֤ʧ�ܴ���
		CollectingAuthenticationErrorCallback errorCallback = new CollectingAuthenticationErrorCallback();
		boolean result = ldapTemplate.authenticate("", filter.toString(), password, errorCallback);
		if(!result) {
			Exception error = errorCallback.getError();
			throw error;
		}
		return result;
	}

}
