<%@page import="jsp_exam.util.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�����ų�?</title>
</head>
<body>
	<%=JdbcUtil.getConnection()%>
</body>
</html>