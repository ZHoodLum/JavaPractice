<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
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

<title><bean:message key="person.page.title" /></title>

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
<TABLE width="815" valign="top">
<tr>
<td width="809" class="td" valign="top">
<TABLE width="809" class="position">
	<TR>
		<TD><bean:message key="person.page.position" /></TD>
		<TD align="right"><a href="person_add.do?method=add"><bean:message key="person.page.add" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<b><html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" /></b>
<TABLE border="0" width="809">
	<TR class="tableheader">
		<TD><bean:message key="person.page.username" /></TD>
		<TD><bean:message key="person.page.name" /></TD>
		<TD><bean:message key="person.page.sex" /></TD>
		<TD><bean:message key="person.page.telphone" /></TD>
		<TD><bean:message key="person.page.email" /></TD>
		<TD><bean:message key="person.page.job" /></TD>
		<TD><bean:message key="person.page.branch" /></TD>
		<TD><bean:message key="person.page.address" /></TD>
		<TD><bean:message key="person.page.accesstime" /></TD>
		<TD><bean:message key="person.page.foundtime" /></TD>
		<TD><bean:message key="button.operation" /></TD>
	</TR>
	<logic:present name="personList">
	<logic:iterate id="person" name="personList" scope="request">
	<TR>
		<TD><bean:write name="person" property="username" scope="page"/></TD>
		<TD><bean:write name="person" property="truename" scope="page"/></TD>
		<TD><bean:write name="person" property="sex" scope="page"/></TD>
		<TD><bean:write name="person" property="telphone" scope="page"/></TD>
		<TD><bean:write name="person" property="email" scope="page"/></TD>
		<TD><bean:write name="person" property="job" scope="page"/></TD>
		<TD><bean:write name="person" property="branch" scope="page"/></TD>
		<TD><bean:write name="person" property="address" scope="page"/></TD>
		<TD><bean:write name="person" property="accessTime" scope="page"/></TD>
		<TD><bean:write name="person" property="foundTime" scope="page"/></TD>
		<TD><a href='person_view.do?method=view&username=<bean:write name="person" property="username" scope="page"/>&view=person'><bean:message key="button.view" /></a>
		<a href='person_edit.do?method=edit&username=<bean:write name="person" property="username" scope="page"/>&update=person'><bean:message key="button.edit" /></a>
		<a href="person.do?method=delete&id=<bean:write name="person" property="id" scope="page"/>"><bean:message key="button.delete" /></a></TD>
	</TR>
	</logic:iterate>
	</logic:present>
</TABLE>

<logic:present name="pager">
<form name="form1" action="person.do?method=list" method="post">
<TABLE border="0" width="809" class="pager">
	<tr><td colspan="4" width="815" height="2" align="center" bgcolor="#1D93DD"></td></tr>
	<TR>
		<TD align="left"><bean:message key="pager.pageSize" />
			<html:select name="pager" property="pageSize" onchange="document.all.pageNo.value='1';document.all.form1.submit();">
				<logic:notEmpty name="pager" scope="request">
					<html:options name="pager" property="pageSizeIndexs" />
				</logic:notEmpty>
			</html:select>
		</TD>
		<TD align="center">
		<bean:message key="pager.rowCount" /><bean:write name="pager" property="rowCount" />
		</TD>
		<TD align="right">
			<a href="javascript:document.all.pageNo.value='<bean:write name="pager" property="firstPageNo" />';document.all.form1.submit();"><bean:message key="pager.firstPageNo" /></a>
			<a href="javascript:document.all.pageNo.value='<bean:write name="pager" property="prePageNo" />';document.all.form1.submit();"><bean:message key="pager.prePageNo" /></a>
			<a href="javascript:document.all.pageNo.value='<bean:write name="pager" property="nextPageNo" />';document.all.form1.submit();"><bean:message key="pager.nextPageNo" /></a>
			<a href="javascript:document.all.pageNo.value='<bean:write name="pager" property="lastPageNo" />';document.all.form1.submit();"><bean:message key="pager.lastPageNo" /></a>
			<html:select name="pager" property="pageNo" onchange="document.all.form1.submit();">
				<logic:notEmpty name="pager" scope="request">
					<html:options name="pager" property="pageNoIndexs" />
				</logic:notEmpty>
			</html:select>
		</TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
</form>
</logic:present>
</td>
</tr>
</TABLE>
<%} %>
</body>
</html>
