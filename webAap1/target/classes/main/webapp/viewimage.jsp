<%@page import="java.io.OutputStream"%>
<%@page import="com.dao.productDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
byte[] image= new productDao().displayImageById(Integer.parseInt(request.getParameter("pid")));
OutputStream o1=response.getOutputStream();
response.setContentType("image/jpeg");
o1.write(image);
o1.flush();
o1.close();
%>
</body>
</html>