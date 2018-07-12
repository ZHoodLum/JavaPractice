package com.struts.util;

public class RegExpression {
	public final static String REG_int = "^\\d*$";
	public final static String REG_float = "^\\d+(\\.\\d+)?$";
	public final static String REG_date = "^[\\d]{4}([-][\\d]{2}){2}$";
	public final static String REG_time = "^[\\d]{4}([-][\\d]{2}){2}([ ][12]{1}[\\d]{1}([:][123456]{1}[\\d]{1}){2}){1}$";
	public final static String REG_datetime = "^[\\d]{4}([-][\\d]{2}){2}([ ][12]{1}[\\d]{1}([:][123456]{1}[\\d]{1}){2}){1}$";
	public final static String REG_email = "^[\\w\\d]+@[\\w\\d]+(\\.[\\w\\d]+)+$";
	public final static String REG_phone = "^(\\d+[-]){0,2}\\d+$";
	public final static String REG_mobile = "^[1]\\d{10}$";
	public final static String REG_postcode = "^\\d{6}$";
//	public final static String REG_url = "/^[\\w]+[:][/]{2}([\\w]+\\.)+([\\w]+[/])+[\\w]+[.][\\w]+$/";
	public final static String REG_url = "^[\\w]+[:][/]{2}([\\w]+\\.)+([\\w]+[/])+[\\w\\.]*$";
	public final static String REG_year = "^\\d{4}$";
	public final static String REG_month = "^\\d{1,2}$";
	public final static String REG_day = "^\\d{1,2}$";

};