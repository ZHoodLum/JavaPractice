package com.neusoft.test1;
import java.io.Serializable;
import java.util.Date;
public class Entitycs implements Serializable {
	static final long serialVersionUID=1L;
	
	private String name;
	private Double pay;
	private Double gain;
	private Double ward;
	private Date date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPay() {
		return pay;
	}
	public void setPay(Double pay) {
		this.pay = pay;
	}
	public Double getGain() {
		return gain;
	}
	public void setGain(Double gain) {
		this.gain = gain;
	}
	public Double getWard() {
		return ward;
	}
	public void setWard(Double ward) {
		this.ward = ward;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Entitycs [name=" + name + ", pay=" + pay + ", gain=" + gain + ", ward=" + ward + ", date=" + date + "]";
	}
	
	
}
