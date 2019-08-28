package crsjk;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnDao {
	/**
	 * 链接数据库
	 */
	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//通过反射装载数据库驱动
			//获取数据库的链接对象
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.10/bookmg", "root", "aaaa");
			return conn; //将链接数据库的对象返回 
		} catch (Exception e) {
			e.printStackTrace();
			return null; //如果出异常了,就返回null
		}
	}
	
	/*public Connection getConn2() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//通过反射装载数据库驱动
			//获取数据库的链接对象
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.16:3306/cccp?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8","root","123456");
			return conn; //将链接数据库的对象返回 
		} catch (Exception e) {
			e.printStackTrace();
			return null; //如果出异常了,就返回null
		}
	}
	*/
	
}
