package crsjk;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnDao {
	/**
	 * �������ݿ�
	 */
	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//ͨ������װ�����ݿ�����
			//��ȡ���ݿ�����Ӷ���
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.10/bookmg", "root", "aaaa");
			return conn; //���������ݿ�Ķ��󷵻� 
		} catch (Exception e) {
			e.printStackTrace();
			return null; //������쳣��,�ͷ���null
		}
	}
	
	/*public Connection getConn2() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//ͨ������װ�����ݿ�����
			//��ȡ���ݿ�����Ӷ���
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.16:3306/cccp?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8","root","123456");
			return conn; //���������ݿ�Ķ��󷵻� 
		} catch (Exception e) {
			e.printStackTrace();
			return null; //������쳣��,�ͷ���null
		}
	}
	*/
	
}
