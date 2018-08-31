package com.neusoft.test1;
import java.io.Serializable;
import java.util.Date;
public class Entitywpr implements Serializable {
	static final long serialVersionUID=1L;
	
	private String wnumber;
	private String wname;
	private Integer wlevel;
	private String unumber;
	public String getWnumber() {
		return wnumber;
	}
	public void setWnumber(String wnumber) {
		this.wnumber = wnumber;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public Integer getWlevel() {
		return wlevel;
	}
	public void setWlevel(Integer wlevel) {
		this.wlevel = wlevel;
	}
	public String getUnumber() {
		return unumber;
	}
	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Entitywpr [wnumber=" + wnumber + ", wname=" + wname + ", wlevel=" + wlevel + ", unumber=" + unumber
				+ "]";
	}
	
	
	
	
}
