<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.product"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	product p = (product) request.getAttribute("product");
	%>
	<%
	ArrayList<String> ptypes = new ArrayList();
	ptypes.add("Fashion");
	ptypes.add("Mobile and Accessories");
	ptypes.add("Grocery");
	ptypes.add("Electronics and Home Appliances");
	ptypes.add("Cosmatic");
	ptypes.add("Health and Medicine");
	%>



	<center>
		<h3>Product From</h3>
		<hr>
		<form action="ProductServlete" method="post">
			<table cellpadding="2" width="25%" bgcolor="99FFFF" align="center"
				cellspacing="2">
				<tr>
				<td align="center" colspan="2"><img src="viewimage.jsp?pid=<%=p.getPid()%>" height="200" width="200"></td>
				<tr>
					<td align="center">Product ID :</td>
					<td><input type="text" name="pid" readonly="readonly"
						value="<%=p.getPid()%>"></td>
				</tr>
				<tr>
					<td align="center">Product Name :</td>
					<td><input type="text" name="pname" value="<%=p.getPname()%>"></td>
				</tr>
				<tr>
					<td align="center">Product Type :</td>
					<td><select name="ptype">
							<%
							for (String s : ptypes) {
								if (s.equalsIgnoreCase(p.getPtype())) {
							%>
							<option value="<%=s%>" selected="selected"><%=s%></option>
							<%
							} else {
							%>
							<option value="<%=s%>"><%=s%></option>
							<%
							}
							}
							%>
					</select></td>
				</tr>
				<tr>
					<td align="center">Product Description :</td>
					<td><textarea rows="5" cols="15" name="pdescription"><%=p.getPdescription()%></textarea></td>
				</tr>
				<tr>
					<td align="center">Product price :</td>
					<td><input type="text" name="pprice"
						value="<%=p.getPprice()%>"></td>
				</tr>
				<tr>

					<td colspan="2" align="center"><input type="submit" name="b1"
						value="Update"></td>
				</tr>

			</table>
			</from>
	</center>
</body>
</html>