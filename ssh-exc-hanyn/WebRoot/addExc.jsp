<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addExc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form method="post" action="insertAction.action"  enctype="multipart/form-data">
	<table>
<tr>
	<td>异常信息</td>
	<td><textarea name="exceptions.excInfo" rows="" cols=""></textarea></td>
</tr>
<tr>
	<td>异常描述</td>
	<td><textarea name="exceptions.excCdes" rows="" cols=""></textarea></td>
</tr>
<tr>
	<td>异常截图</td>
	<td><input type="file" name="headImg" /></td>
</tr>
<tr>
	<td>解决方法</td>
	<td><textarea name="exceptions.excSolve" rows="" cols=""></textarea></td>
</tr>
<tr>
	<td colspan="1" align="center"><input type="submit"> <input type="reset"></td>
</tr>
</table>
</form>
  </body>
</html>
