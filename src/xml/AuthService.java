package xml;

import java.util.List;

import crsjk.Auth;

/**
 * ҵ�����,Ҳ��ҵ����Ʋ�,����ҵ����ص��߼��������ﴦ��
 */
public class AuthService {

	AuthDao authdao = new AuthDao();
	
	/**
	 * ��ѯ
	 * @return
	 */
	public List<Auth> queryAll(int pageNow,int pageSize){
		List<Auth> list = authdao.queryAll(pageNow,pageSize);
		
		return list;
	}
	/**
	 * �������
	 * @param user
	 */
	public void insert(Auth auth) {
		authdao.insert(auth);
	}
	/**
	 * ����idɾ������
	 * @param id Ҫɾ�������ݵ�id
	 */
	public void delete(Integer id) {
		authdao.delete(id);
	}
	
	/**
	 * �޸�
	 * @param user
	 */
	public void update(Auth auth) {
		authdao.update(auth);
	}
	/**
	 * ����id��ȡһ������
	 * @param id
	 * @return
	 */
	public Auth get(Integer id){
		Auth auth = authdao.get(id);
		return auth;
	}
	/**
	 * ����ÿҳ��ʾ�������õ���ǰ��ҳ��
	 * @param pageSize ÿҳ��ʾ������
	 * @return ��ҳ��
	 */
	public int getPageTotal(int pageSize) {
		return authdao.getPageTotal(pageSize);
	}
}	
