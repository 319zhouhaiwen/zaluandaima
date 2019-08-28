package xml;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import crsjk.Auth;

/**
 *	DAO层，数据持久层
 *	账户DAO
 */
public class AuthDao extends ConnDao{
	
	/**
	 * 
	 * @param pageNow  当前页数
	 * @param pageSize 每页显示条数
	 * 查询权限
	 * @return List<User>
	 * select * from user limit (当前页数-1)*每页显示条数,每页显示条数; 
	 */
	public List<Auth> queryAll(int pageNow,int pageSize) {
		List<Auth> list = new ArrayList<>();
		Connection conn = getConn(); //得到数据库链接对象
		try {
			Statement st = conn.createStatement(); //创建一个执行sql的对象
			int limitStart = (pageNow-1)*pageSize;
			String sql = "select * from b_auth order by create_time desc limit "+limitStart+","+pageSize+";   ";
			ResultSet rs = st.executeQuery(sql); //执行查询的sql
			while (rs.next()) { //循环查询的结果
				Auth auth = new Auth(); //创建对象用来装每一条数据
				auth.setId(rs.getInt("id"));
				auth.setCode(rs.getString("code"));
				auth.setName(rs.getString("name"));
				auth.setUrl(rs.getString("url"));
				auth.setpCode(rs.getString("p_code"));
				auth.setIsButton(rs.getString("is_button"));
				auth.setIsDel(rs.getString("is_del"));
				list.add(auth);//将对象放到集合中存起来
			}
			rs.close();//关闭资源
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;  //将集合返回
	}
	
	/**
	 * 将数据插入到数据库表中
	 */
	public void insert(Auth auth) {
		Connection conn = getConn(); //得到数据库链接对象
		try {
			Statement st = conn.createStatement();//创建一个执行sql的对象
			if(null!=auth.getpCode()) {
				
				String sql = "insert into b_auth(code,name,url,p_code,is_button)values('"+auth.getCode()+"','"+auth.getName()+"','"+auth.getUrl()+"','"+auth.getpCode()+"','"+auth.getIsButton()+"')";
				st.executeUpdate(sql);//执行sql
			}else {
				String sql = "insert into b_auth(code,name,url,is_button)values('"+auth.getCode()+"','"+auth.getName()+"','"+auth.getUrl()+"','"+auth.getIsButton()+"')";
				st.executeUpdate(sql);//执行sql
			}
			st.close();//关闭资源
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 修改用户数据
	 * @param user
	 */
	public void update(Auth auth) {
		Connection conn = getConn(); //得到数据库链接对象
		try {
			Statement st = conn.createStatement(); //创建一个执行sql的对象
			String sql = "update b_auth set code='"+auth.getCode()+"', name='"+auth.getName()+"', url='"+auth.getUrl()+"' ,p_code='"+auth.getpCode()+"', is_button='"+auth.getIsButton()+"' ,modifier='"+auth.getModifier()+"', modify_time='"+auth.getModify_time()+"' where id ="+auth.getId();
			st.executeUpdate(sql); //执行sql
			st.close(); //关闭资源
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 根据id删除数据
	 * @param id 要删除的数据的id
	 */
	public void delete(Integer id) {
		Connection conn = getConn(); //得到数据库链接对象
		try {
			Statement st = conn.createStatement(); //创建一个执行sql的对象
			String sc="1";
			String sql = "update  b_auth set is_del='"+sc+"' where id ="+id;
			st.executeUpdate(sql); //执行sql
			st.close(); //关闭资源
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 查询用户数据进行回显
	 * @return List<User>
	 */
	public Auth get(Integer id) {
		Auth auth = new Auth(); //创建对象用来装一条数据
		Connection conn = getConn(); //得到数据库链接对象
		try {
			Statement st = conn.createStatement(); //创建一个执行sql的对象
			String sql = "select * from b_auth where id = "+id;
			ResultSet rs = st.executeQuery(sql); //执行查询的sql
			while (rs.next()) { //循环查询的结果
				auth.setId(rs.getInt("id"));
				auth.setCode(rs.getString("code"));
				auth.setName(rs.getString("name"));
				auth.setUrl(rs.getString("url"));
				auth.setpCode(rs.getString("p_code"));
				auth.setIsButton(rs.getString("is_button"));
				auth.setIsDel(rs.getString("is_del"));
			}
			rs.close();//关闭资源
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return auth;  //将集合返回
	}
	
	/**
	 * 根据每页显示的条数得到当前总页数
	 * @param pageSize 每页显示的条数
	 * @return 总页数
	 */
	public int getPageTotal(int pageSize) {
		int totalNum = 0;
		Connection conn = getConn(); //得到数据库链接对象
		try {
			Statement st = conn.createStatement(); //创建一个执行sql的对象
			String sql = "select count(*)  as num from b_auth; ";
			ResultSet rs = st.executeQuery(sql); //执行查询的sql
			while (rs.next()) { //循环查询的结果
				totalNum = rs.getInt("num"); //将总数据条数查出来放到变量totalNum中
			}
			rs.close();//关闭资源
			st.close();
			conn.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//根据每页条数计算总页数
		int pageTotal = totalNum / pageSize; 
		int yshu = totalNum % pageSize; //还要判断是否是除断的
		if (yshu != 0) { //如果没有除断表示还需要多加一页
			pageTotal = pageTotal + 1;
		}
		return pageTotal;
	}
}
