package ldap.sample;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		
		List<String> names = userDao.getAllUserNames();		
		System.out.print("插入前所有用户名称：");
		System.out.println(names);
		
		User user = new User();
		user.setId("100");
		user.setName("XXX");
		user.setPassword("000000");
		user.setEmail("xxx@test.com");
		userDao.create(user);
		
		System.out.print("插入后所有用户名称：");
		System.out.println(userDao.getAllUserNames());
		
		System.out.print("查询指定ID用户:");
		System.out.println(userDao.getUserByName("admin"));
		
		System.out.print("查询所有用户:");
		List<User> allUsers = userDao.findAll();
		System.out.println(allUsers);
		
		user.setEmail("new@test.com");
		userDao.update(user);
		System.out.print("修改后用户email：");
		System.out.println(userDao.getUserByName("XXX").getEmail());
		
		
		System.out.print("认证新用户: ");
		try {
			userDao.authenticate("XXX", "000000");
			System.out.println("Welcome!");
		} catch (Exception e) {
			System.out.println("Error!");
		}
		
		userDao.delete(user);
		System.out.print("删除后所有用户:");
		System.out.println(userDao.getAllUserNames());
		
	}

}
