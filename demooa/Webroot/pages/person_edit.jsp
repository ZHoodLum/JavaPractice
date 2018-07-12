<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ page import="com.struts.util.Constants"%>
<html:html locale = "true"/> 
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><bean:message key="person_edit.page.title" /></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is demo">
</head>

<body>
<%
  if(session.getAttribute("username")==null){
	  response.sendRedirect(path+"/error.jsp");
  }
  else{
%>
<TABLE width="815" >
<tr>
<td width="809" class="td" valign="top">
<%if(!request.getParameter("update").equals("my")){%>
<TABLE width="809" class="position">
	<TR>
		<TD><bean:message key="person_edit.page.position" /></TD>
		<TD align="right"><a href="person.do?method=back"><bean:message
			key="person_edit.page.back" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<%}%>
<form name="form1" action="person_edit.do?method=update" method="post">
<b><html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" /></b>

<logic:present name="personFormBean">
	<html:hidden property="id" name="personFormBean"/>
</logic:present>
<logic:notPresent name="personFormBean">
	<input type="hidden" name="id">
</logic:notPresent>
<logic:present name="personFormBean">
	<html:hidden property="accessTime" name="personFormBean"/>
</logic:present>
<logic:notPresent name="personFormBean">
	<input type="hidden" name="accessTime">
</logic:notPresent>
<logic:present name="personFormBean">
	<html:hidden property="foundTime" name="personFormBean"/>
</logic:present>
<logic:notPresent name="personFormBean">
	<input type="hidden" name="foundTime">
</logic:notPresent>
<logic:present name="personFormBean">
	<html:hidden property="islogging" name="personFormBean"/>
</logic:present>
<logic:notPresent name="personFormBean">
	<input type="hidden" name="islogging">
</logic:notPresent>
<logic:present name="personFormBean">
	<html:hidden property="myupdate" name="personFormBean"/>
</logic:present>
<logic:notPresent name="personFormBean">
	<input type="hidden" name="myupdate">
</logic:notPresent>
		
<TABLE border="0" width="809">
	<TR>
		<TD><bean:message key="person.page.username" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="username" name="personFormBean"  style="border:0;" readonly="true"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="username" style="border:0;" readonly="true">
		</logic:notPresent>
		 <html:errors property="username" /></TD>
	</TR>
	<%if (!session.getAttribute(Constants.USERID_KEY).equals(Constants.NORMALUSER)) {%>
	<TR>
		<TD><bean:message key="person.page.userid" /></TD>
		<TD><logic:present name="personFormBean">
			<html:select property="userid" name="personFormBean">
			<html:option value="0"><bean:message key="person.page.system"/></html:option>
			<html:option value="1"><bean:message key="person.page.normal"/></html:option>
			</html:select>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="userid" >
		</logic:notPresent>
		 <html:errors property="userid" /></TD>
	</TR>
	<%} %>
	<%if(request.getParameter("update").equals("my")){%>
	<TR>
		<TD><bean:message key="person.page.password1" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="password1" name="personFormBean" maxlength="50"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="password" name="password1" maxlength="50">
		</logic:notPresent>
		 <html:errors property="password1" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.password2" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="password2" name="personFormBean" maxlength="50"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="password" name="password2" maxlength="50">
		</logic:notPresent>
		 <html:errors property="password2" /></TD>
	</TR>
	<%} else{%>
	<logic:present name="personFormBean">
		<html:hidden property="password1" name="personFormBean"/>
	</logic:present>
	<logic:notPresent name="personFormBean">
		<input type="hidden" name="password1">
	</logic:notPresent>
	<logic:present name="personFormBean">
		<html:hidden property="password2" name="personFormBean"/>
	</logic:present>
	<logic:notPresent name="personFormBean">
		<input type="hidden" name="password2">
	</logic:notPresent>
	<%} %>
	<TR>
		<TD><bean:message key="person.page.name" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="truename" name="personFormBean" maxlength="50"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="truename" maxlength="50">
		</logic:notPresent>
		 <html:errors property="truename" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.sex" /></TD>
		<TD><logic:present name="personFormBean">
			<html:select property="sex" name="personFormBean">
			<html:option value="男"><bean:message key="person.page.man"/></html:option>
			<html:option value="女"><bean:message key="person.page.woman"/></html:option>
			</html:select>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="sex" maxlength="10">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.telphone" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="telphone" name="personFormBean" maxlength="20"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="telphone" maxlength="20">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.email" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="email" name="personFormBean" maxlength="50"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="email" maxlength="50">
		</logic:notPresent><html:errors property="email" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.job" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="job" name="personFormBean" maxlength="20"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="job" maxlength="20">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.branch" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="branch" name="personFormBean" maxlength="100"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="branch" maxlength="100">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.address" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="address" name="personFormBean" maxlength="100"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="address" maxlength="100">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD colspan="2"><input type="submit"
			value="<bean:message key='button.submit' />"></TD>
	</TR>
</TABLE>
</form>
</td>
</tr>
</TABLE>
<%} %>
</body>
</html>
