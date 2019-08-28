package zy;

public class Users {
	private String name;//用户名
	private Integer phone;//手机号
	private String account;//账户
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", phone=" + phone + ", account=" + account + "]";
	}
	
}
