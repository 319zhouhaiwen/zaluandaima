package zy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Dao {
		public void insertorders(Orders orders) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://http://localhost/zy", "root", "3194498557");
				Statement stat=conn.createStatement();
				String sql="insert into orders(orderno,ordertotal)values('"+orders.getOrderno()+"','"+orders.getOrdertotal()+"')";
				stat.executeUpdate(sql);
				stat.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		public void insertusers(Users users) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://http://localhost/zy", "root", "3194498557");
				Statement stat=conn.createStatement();
				String sql="insert into users(name,phone,account)values('"+users.getName()+"','"+users.getPhone()+"','"+users.getAccount()+"')";
				stat.executeUpdate(sql);
				stat.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		public void insert(OrderGoods ordergoods) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://http://localhost/zy", "root", "3194498557");
				Statement stat=conn.createStatement();
				String sql="insert into ordergoods(pname,prodcode,price,number,total)values('"+ordergoods.getPname()+"','"+ordergoods.getProdcode()+"','"+ordergoods.getPrice()+"','"+ordergoods.getNumber()+"','"+ordergoods.getTotal()+"')";
				stat.executeUpdate(sql);
				stat.close();
				conn.close();
			} catch (Exception e) {
			}
		}
}
