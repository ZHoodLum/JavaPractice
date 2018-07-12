<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<html:html locale = "true"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is demo">
	
	<link rel="stylesheet" type="text/css" href="styles.css">

  </head>
  
  <body>
    <table class="td">
    <tr bgcolor="lightgrey">
     <td align="center"><bean:message key="errors.friendtishi" />
     <bean:message key="errors.tanhao" /></td>
    </tr>
    <tr>
     <td align="center"><bean:message key="errors.please" />
     <a href="index.do"><bean:message key="errors.login" /></a>
     <bean:message key="errors.tanhao" /></td>
    </tr>
    </table>
  </body>
</html>
