package com.struts.util;

public class CheckStr 
{
	public CheckStr(){}
	public String dostring(String str)
	{
		str=str.replaceAll(";", "");
		str=str.replaceAll("&", "&amp;");
		str=str.replaceAll("<", "&lt;");
		str=str.replaceAll(">", "&gt;");
		str=str.replaceAll("'", "");
		str=str.replaceAll("--", "");
		str=str.replaceAll("/", "");
		str=str.replaceAll("%", "");
		return str;
	}

}
