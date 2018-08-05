<%@ page import="com.offcn.util.SessionUtil" %>
<%@ page import="com.offcn.pojo.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title><%=request.getParameter("title")%></title>
	<link rel="stylesheet" href="/assets/public/css/<%=request.getParameter("css_name")%>.css">
</head>
<body>
	<jsp:include flush="true" page="./bar.jsp"/>
	