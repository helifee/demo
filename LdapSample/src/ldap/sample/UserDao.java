package ldap.sample;

import java.util.List;

public interface UserDao {

	//查询
	public List<String> getAllUserNames();
	public User getUserByName(String id);
	public List<User> findAll();
	
	//绑定
	public void create(User user);
	
	//更新
	public void update(User user);
	
	//解绑定
	public void delete(User user);

	//验证用户
	public boolean authenticate(String userName, String password) throws Exception;
}
