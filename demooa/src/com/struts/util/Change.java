package com.struts.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Change {
    public static int strtoint(String source){
    	int num=0;
    	try{
    		num=Integer.parseInt(source);
    	}
    	catch(Exception e){
    		 e.printStackTrace();num=-1;
    	} 
        return num;
    }
    
    public static String inttostr(int source){
    	String strnum="";
    	try{
    		strnum=Integer.toString(source);
    	}
    	catch(Exception e){
    		 e.printStackTrace();strnum="";
    	} 
        return strnum;
    }
    
    public static float strtofloat(String source){
    	float num=0;
    	try{
    		num=Float.parseFloat(source);
    	}
    	catch(Exception e){
    		e.printStackTrace();num=-1;
    	}
        
    	return num;
    }
	
    public static String toChinese(String str){
    	if(str==null)str="";
    	try{
    		str=new String(str.getBytes("ISO-8859-1"),"gbk");
    	}
    	catch(Exception e){e.printStackTrace();return "";}
        return str;
    }
    
    public static String datetostr(Date date){
    	String strtime;
    	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	strtime=format.format(date);
    	return strtime;
    }
    
    
    
    public static String check(int length,String INDate){
    	String subDate="";
    	String separate="-";
    	if (INDate=="")
    		return "oa.time.YMD.not.wanzheng";
    	
    	if(INDate.indexOf(separate,0)==-1)return "oa.time.format.queshao.separate";
    	
    	subDate=INDate.substring(0,INDate.indexOf(separate));
    	if(subDate.length()!=length)
    	     return "oa.time.YMD.length.not.right";
    	if(strtoint(subDate)==-1)
    		return "oa.time.YMD.context.not.number";
    	
    	return "success";
	}
    public static String checkdate(String INDate){
    	
    	//判断年份
    	
    	String separate="-";
    	String return_str="oa.meet.notime.error";
    	
    	return_str=check(4,INDate);
    	if(!return_str.equals("success"))return return_str;
    	
    	String subYY=INDate.substring(0,4);
    	int subYYY=strtoint(subYY);
    	
    	INDate=INDate.substring(INDate.indexOf(separate)+1);
        
    	//判断月份
    	
    	return_str=check(2,INDate);
    	if(!return_str.equals("success"))return return_str;
    	
    	String subMM=INDate.substring(0,INDate.indexOf(separate));
    	int subMMM=strtoint(subMM);
    	if(!(subMMM>=1&&subMMM<=12))
    		return "oa.time.MM.no.have";
    	  	
    	INDate=INDate.substring(INDate.indexOf(separate)+1);
    	
    	//判断日
    	
    	String subDD=INDate;
    	int subDDD=strtoint(subDD);
    	if(subDD.length()!=2)
    	     return "oa.time.YMD.length.not.right";
    	if(subDDD==-1)
    		return "oa.time.YMD.context.not.number";
    	
     	if(subMMM==2){
    	   if((subYYY%4==0&&subYYY%100!=0)||subYYY%400==0){
    	       if(subDDD>29) return return_str="oa.time.ruinian.2.day.wrong";	
    	   }
    	   else{
    		   if(subDDD>28) return return_str="oa.time.not.ruinian.2.day.wrong";
    	   }
    	}
    	else{
    		if(subMMM==1||subMMM==3||subMMM==5||subMMM==7||subMMM==8||subMMM==10||subMMM==12){
    			if(subDDD>31) return return_str="oa.time.31.day.wrong";
    		}
    		else{
    			if(subDDD>30) return return_str="oa.time.30.day.wrong";
    		}
    	}
    	
    	return return_str;
    }
}
