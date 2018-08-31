package com.neusoft.test1;
import java.io.Serializable;
import java.util.Date;
public class Entitytcbi implements Serializable {
	static final long serialVersionUID=1L;
	
	private String username;
	private String password;
	private String email;
	private Double money;
	private Integer grantuse;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getGrantuse() {
		return grantuse;
	}
	public void setGrantuse(Integer grantuse) {
		this.grantuse = grantuse;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Entitytcbi [username=" + username + ", password=" + password + ", email=" + email + ", money=" + money
				+ ", grantuse=" + grantuse + "]";
	}

	
	
}
