package zy;

public class OrderGoods {
	private String pname;//�û�������Ʒ����
	private String prodcode;//��Ʒ����
	private double price;//��Ʒ����
	private Integer number;//��������
	private double total;//��Ʒ�ܼ�
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getProdcode() {
		return prodcode;
	}
	public void setProdcode(String prodcode) {
		this.prodcode = prodcode;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "OrderGoods [pname=" + pname + ", prodcode=" + prodcode + ", price=" + price + ", number=" + number
				+ ", total=" + total + "]";
	}
	
}
