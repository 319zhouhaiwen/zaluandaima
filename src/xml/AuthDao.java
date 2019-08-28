package xml;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import crsjk.Auth;

/**
 *	DAO�㣬���ݳ־ò�
 *	�˻�DAO
 */
public class AuthDao extends ConnDao{
	
	/**
	 * 
	 * @param pageNow  ��ǰҳ��
	 * @param pageSize ÿҳ��ʾ����
	 * ��ѯȨ��
	 * @return List<User>
	 * select * from user limit (��ǰҳ��-1)*ÿҳ��ʾ����,ÿҳ��ʾ����; 
	 */
	public List<Auth> queryAll(int pageNow,int pageSize) {
		List<Auth> list = new ArrayList<>();
		Connection conn = getConn(); //�õ����ݿ����Ӷ���
		try {
			Statement st = conn.createStatement(); //����һ��ִ��sql�Ķ���
			int limitStart = (pageNow-1)*pageSize;
			String sql = "select * from b_auth order by create_time desc limit "+limitStart+","+pageSize+";   ";
			ResultSet rs = st.executeQuery(sql); //ִ�в�ѯ��sql
			while (rs.next()) { //ѭ����ѯ�Ľ��
				Auth auth = new Auth(); //������������װÿһ������
				auth.setId(rs.getInt("id"));
				auth.setCode(rs.getString("code"));
				auth.setName(rs.getString("name"));
				auth.setUrl(rs.getString("url"));
				auth.setpCode(rs.getString("p_code"));
				auth.setIsButton(rs.getString("is_button"));
				auth.setIsDel(rs.getString("is_del"));
				list.add(auth);//������ŵ������д�����
			}
			rs.close();//�ر���Դ
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;  //�����Ϸ���
	}
	
	/**
	 * �����ݲ��뵽���ݿ����
	 */
	public void insert(Auth auth) {
		Connection conn = getConn(); //�õ����ݿ����Ӷ���
		try {
			Statement st = conn.createStatement();//����һ��ִ��sql�Ķ���
			if(null!=auth.getpCode()) {
				
				String sql = "insert into b_auth(code,name,url,p_code,is_button)values('"+auth.getCode()+"','"+auth.getName()+"','"+auth.getUrl()+"','"+auth.getpCode()+"','"+auth.getIsButton()+"')";
				st.executeUpdate(sql);//ִ��sql
			}else {
				String sql = "insert into b_auth(code,name,url,is_button)values('"+auth.getCode()+"','"+auth.getName()+"','"+auth.getUrl()+"','"+auth.getIsButton()+"')";
				st.executeUpdate(sql);//ִ��sql
			}
			st.close();//�ر���Դ
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * �޸��û�����
	 * @param user
	 */
	public void update(Auth auth) {
		Connection conn = getConn(); //�õ����ݿ����Ӷ���
		try {
			Statement st = conn.createStatement(); //����һ��ִ��sql�Ķ���
			String sql = "update b_auth set code='"+auth.getCode()+"', name='"+auth.getName()+"', url='"+auth.getUrl()+"' ,p_code='"+auth.getpCode()+"', is_button='"+auth.getIsButton()+"' ,modifier='"+auth.getModifier()+"', modify_time='"+auth.getModify_time()+"' where id ="+auth.getId();
			st.executeUpdate(sql); //ִ��sql
			st.close(); //�ر���Դ
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * ����idɾ������
	 * @param id Ҫɾ�������ݵ�id
	 */
	public void delete(Integer id) {
		Connection conn = getConn(); //�õ����ݿ����Ӷ���
		try {
			Statement st = conn.createStatement(); //����һ��ִ��sql�Ķ���
			String sc="1";
			String sql = "update  b_auth set is_del='"+sc+"' where id ="+id;
			st.executeUpdate(sql); //ִ��sql
			st.close(); //�ر���Դ
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * ��ѯ�û����ݽ��л���
	 * @return List<User>
	 */
	public Auth get(Integer id) {
		Auth auth = new Auth(); //������������װһ������
		Connection conn = getConn(); //�õ����ݿ����Ӷ���
		try {
			Statement st = conn.createStatement(); //����һ��ִ��sql�Ķ���
			String sql = "select * from b_auth where id = "+id;
			ResultSet rs = st.executeQuery(sql); //ִ�в�ѯ��sql
			while (rs.next()) { //ѭ����ѯ�Ľ��
				auth.setId(rs.getInt("id"));
				auth.setCode(rs.getString("code"));
				auth.setName(rs.getString("name"));
				auth.setUrl(rs.getString("url"));
				auth.setpCode(rs.getString("p_code"));
				auth.setIsButton(rs.getString("is_button"));
				auth.setIsDel(rs.getString("is_del"));
			}
			rs.close();//�ر���Դ
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return auth;  //�����Ϸ���
	}
	
	/**
	 * ����ÿҳ��ʾ�������õ���ǰ��ҳ��
	 * @param pageSize ÿҳ��ʾ������
	 * @return ��ҳ��
	 */
	public int getPageTotal(int pageSize) {
		int totalNum = 0;
		Connection conn = getConn(); //�õ����ݿ����Ӷ���
		try {
			Statement st = conn.createStatement(); //����һ��ִ��sql�Ķ���
			String sql = "select count(*)  as num from b_auth; ";
			ResultSet rs = st.executeQuery(sql); //ִ�в�ѯ��sql
			while (rs.next()) { //ѭ����ѯ�Ľ��
				totalNum = rs.getInt("num"); //������������������ŵ�����totalNum��
			}
			rs.close();//�ر���Դ
			st.close();
			conn.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//����ÿҳ����������ҳ��
		int pageTotal = totalNum / pageSize; 
		int yshu = totalNum % pageSize; //��Ҫ�ж��Ƿ��ǳ��ϵ�
		if (yshu != 0) { //���û�г��ϱ�ʾ����Ҫ���һҳ
			pageTotal = pageTotal + 1;
		}
		return pageTotal;
	}
}
