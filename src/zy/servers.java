package zy;

public class servers {
	Dao dao=new Dao();
	public void insertorders(Orders orders) {
		dao.insertorders(orders);
	}
	public void insertusers(Users users) {
		dao.insertusers(users);
	}
	public void insert(OrderGoods ordergoods) {
		dao.insert(ordergoods);
	}
}
