<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h3>Student Details</h3>
		<hr>
		<%
		student s = (student) request.getAttribute("student");
		
		ArrayList<String> list =new ArrayList();
		list.add("cricket");
		list.add("cooking");
		list.add("travelling");
		list.add("reading book");
		list.add("writing");

		
		%>
		<form action="StudentServlet1" method="get">
			<table>
				<tr>
					<td align="right">Id :</td>
					<td><input type="text" name="sid" value="<%=s.getSid()%>"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td align="right">Name :</td>
					<td><input type="text" name="sname" value="<%=s.getSname()%>"></td>
				</tr>
				<tr>
					<td align="right">Email :</td>
					<td><input type="email" name="semail"
						value="<%=s.getSemail()%>"></td>
				</tr>
				<tr>
					<td align="right">Password :</td>
					<td><input type="password" name="spassword"
						value="<%=s.getSpassword()%>"></td>
				</tr>
				<tr>
					<td align="right">Gender :</td>
					<td>
						<%
						if (s.getSgender().equalsIgnoreCase("Male")) {
						%> <input type="radio" name="sgender" value="Male"
						checked="checked">Male <input type="radio" name="sgender"
						value="Female">Female <%
 } else {
 %> <input type="radio" name="sgender" value="Male">Male <input
						type="radio" name="sgender" value="Female" checked="checked">Female
						<%
 }
 %>
					</td>
				</tr>
				<tr>
					<td align="right">Address :</td>
					<td><textarea rows="5" cols="15" name="saddress"><%=s.getSaddress()%></textarea></td>
				</tr>
				<tr>
					<td align="right">Percentage :</td>
					<td><input type="text" name="spercentage"
						value="<%=s.getSpercentage()%>"></td>
				</tr>
				<tr>
					<td align="right">Hobbies :</td>
					<td>
						<%
						int a=0;
					for(String s1 : list){
						a++;
						if(a%3==0){%>
							<br>
						<%}
						if(s.getShobbies().contains(s1)){%> <input type="checkbox"
						name="shobbies" value="<%=s1 %>" checked="checked"><%=s1 %>
						<%}
						else
						{%> <input type="checkbox" name="shobbies" value="<%=s1%>"><%=s1 %>
						<%}
					}
					%>
					</td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" name="b1"
						value="Update"></td>
				</tr>
				</form>
			</table>
	</center>
</body>
</html>