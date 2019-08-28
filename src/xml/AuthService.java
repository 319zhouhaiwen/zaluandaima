package xml;

import java.util.List;

import crsjk.Auth;

/**
 * 业务处理层,也叫业务控制层,所有业务相关的逻辑都在这里处理
 */
public class AuthService {

	AuthDao authdao = new AuthDao();
	
	/**
	 * 查询
	 * @return
	 */
	public List<Auth> queryAll(int pageNow,int pageSize){
		List<Auth> list = authdao.queryAll(pageNow,pageSize);
		
		return list;
	}
	/**
	 * 添加数据
	 * @param user
	 */
	public void insert(Auth auth) {
		authdao.insert(auth);
	}
	/**
	 * 根据id删除数据
	 * @param id 要删除的数据的id
	 */
	public void delete(Integer id) {
		authdao.delete(id);
	}
	
	/**
	 * 修改
	 * @param user
	 */
	public void update(Auth auth) {
		authdao.update(auth);
	}
	/**
	 * 根据id获取一个对象
	 * @param id
	 * @return
	 */
	public Auth get(Integer id){
		Auth auth = authdao.get(id);
		return auth;
	}
	/**
	 * 根据每页显示的条数得到当前总页数
	 * @param pageSize 每页显示的条数
	 * @return 总页数
	 */
	public int getPageTotal(int pageSize) {
		return authdao.getPageTotal(pageSize);
	}
}	
