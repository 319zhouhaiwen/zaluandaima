package zy;

public class Orders {
	private String  orderno;//�������
	private double ordertotal;//�����ܼ۸�
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public double getOrdertotal() {
		return ordertotal;
	}
	public void setOrdertotal(double ordertotal) {
		this.ordertotal = ordertotal;
	}
	@Override
	public String toString() {
		return "Users [orderno=" + orderno + ", ordertotal=" + ordertotal + "]";
	}
}
