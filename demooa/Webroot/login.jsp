<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
Random rand1=new Random();
String[] sourcestr1={"Äã","ºÃ","²»","Âä","·«"};
String str1="";
String img1="";
int intrand1=0;
for(int i=0;i<4;i++){
	intrand1=Math.abs(rand1.nextInt(5));   
	str1=str1+sourcestr1[intrand1].trim();  
	img1=img1+"<img src='images/checkcode/"+intrand1+".gif' width='19' height='20'>";
}
session.setAttribute("checkcode",str1);  
%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><bean:message key="login.page.title" /></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="DEMO OA">
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body style="margin-top:100">
<center>

<table width="800" height="613" border="0" align="center" background="images/login.gif" >
    <tr valign="middle">
      <td>
      <form name="form1" action="login.do" method="post" >
      <table width="502" height="282" border="0" align="center" >
  
    <tr>
      <td valign="middle">&nbsp;</td>
      <td height="50" colspan="1" align="left" valign="middle"></td>
    </tr>
	<tr>
	  <td width="39%" height="20" align="right" valign="middle"><bean:message key="login.page.username"/></td>
	  <td width="61%" height="20" align="left" valign="middle">
        <logic:present name="loginFormBean">
			<html:text property="username" name="loginFormBean"  style="border:1 solid"/>
		</logic:present> 
		<logic:notPresent name="loginFormBean">
		  <input type="text" name="username"  style="border:1 solid">
		</logic:notPresent>
		 <html:errors property="username"/></td>
	</tr>
	<tr>
	  <td width="39%" height="20" align="right" valign="middle">
	  <bean:message key="login.page.password"/></td>
	  <td width="61%" height="20" align="left" valign="middle">
        <logic:present name="loginFormBean">
			<html:password property="password" name="loginFormBean"  style="border:1 solid"/>
		</logic:present> 
		<logic:notPresent name="loginFormBean">
		  <input name="password" type="password"  style="border:1 solid">
		</logic:notPresent>
      <html:errors property="password"/></td>
	</tr>
	<tr>
      <td width="39%" height="20" align="right" valign="middle">
      <bean:message key="login.page.valcode"/></td>
      <td width="61%" height="20" align="left" valign="middle">
        <logic:present name="loginFormBean">
			<html:text property="valcode" name="loginFormBean" style="border:1 solid"/>
		</logic:present> 
		<logic:notPresent name="loginFormBean">
		  <input name="valcode" type="text" style="border:1 solid">
		</logic:notPresent>
        <html:errors property="valcode"/>      </td>
    </tr>
    <tr>
      <td width="39%" height="20" valign="middle">      </td>
      <td width="61%" height="20" valign="middle">
		<%=img1%>      </td>
    </tr>
	<tr align="center">
        <td width="39%" height="20" valign="top">	    </td>
        <td height="40" colspan="2" align="left" valign="top">
            <input name="submit" type="submit" 
			value='<bean:message key="login.page.login" />'> 
          <a href="register.do?method=init" >
      <bean:message key="login.page.register"/></a></td>
	</tr>
</table>
<html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" />
</form>
      </td>
    </tr>
  	</tr>
</table>
 
</center>
</body>
</html>
