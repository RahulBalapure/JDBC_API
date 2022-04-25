<%@page import="com.dao.StudentDao , com.model.student"%>



<html>
<body>

	<center>
		<h3>Student From</h3>
		<hr>
		<form action="StudentServlet1" method="get">
			<table cellpadding="2" width="20%" bgcolor="99FFFF" align="center"
				cellspacing="2">
				<tr>
					<td align="right">Id :</td>
					<td><input type="text" name="sid" value="0"></td>
				</tr>
				<tr>
					<td align="right">Name :</td>
					<td><input type="text" name="sname" placeholder=""></td>
				</tr>
				<tr>
					<td align="right">Email :</td>
					<td><input type="email" name="semail"
						placeholder="Enter your Email"></td>
				</tr>
				<tr>
					<td align="right">Password :</td>
					<td><input type="password" name="spassword"
						placeholder="Enter your Password"></td>
				</tr>
				<tr>
					<td align="right">Gender :</td>
					<td><input type="radio" name="sgender" value="Male">Male
						<input type="radio" name="sgender" value="Female">Female <input
						type="radio" name="sgender" value="Other">Other</td>
				</tr>
				<tr>
					<td align="right">Address :</td>
					<td><textarea rows="5" cols="15" name="saddress"></textarea></td>
				</tr>

				<tr>
					<td align="right">Percentage :</td>
					<td><input type="text" name="spercentage" value="0"></td>
				</tr>
				<tr>
					<td align="right">Hobbies :</td>
					<td><input type="checkbox" name="shobbies" value="cricket">Cricket<br>
						<input type="checkbox" name="shobbies" value="cooking">Cooking
						<br> <input type="checkbox" name="shobbies"
						value="travelling">Travelling <br> <input
						type="checkbox" name="shobbies" value="reading book">Readind
						book <br> <input type="checkbox" name="shobbies"
						value="writing">writing</td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" name="b1"
						value="Add"> <input type="submit" name="b1" value="Delete">
						<input type="submit" name="b1" value="Display"></td>
				</tr>

			</table>
		</form>


		<hr>
		<h3>
			<font>Student List</font>
		</h3>
		<hr>
		<table cellpadding="3" border="2" cellspacing="2">
			<tr bgcolor="MediumSpringGreen">
				<td align="center"><b>Id</b></td>
				<td align="center"><b>Name</b></td>
				<td align="center"><b>Email</b></td>
				<td align="center"><b>Password</b></td>
				<td align="center"><b>Gender</b></td>
				<td align="center"><b>Address</b></td>
				<td align="center"><b>Hobbies</b></td>
				<td align="center"><b>Percentage</b></td>

			</tr>
			<%
			for (student s : new StudentDao().displayAllStudent()) {
			%>

			 <%if (s.getSpercentage()>=50) {%>
			 <tr bgcolor="LemonChiffon">
			 <%} else {%>
				<tr bgcolor="#FF0000"> <%}%>
				
				
				<td align="center" bgcolor="yellow"><%=s.getSid()%></td>
				<td align="center"><%=s.getSname()%></td>
				<td align="center"><%=s.getSemail()%></td>
				<td align="center"><%=s.getSpassword()%></td>


				<%
				if (s.getSgender().equalsIgnoreCase("Male")) {
				%>
				<td align="center" bgcolor="Moccasin"><%=s.getSgender()%></td>
				<%
				} else {
				%>
				<td align="center" bgcolor="pink"><%=s.getSgender()%></td>
				<%
				}
				%>
				<td align="center"><%=s.getSaddress()%></td>
				<td align="center"><%=s.getShobbies()%></td>
				<td align="center"><%=s.getSpercentage()%></td>

			</tr>
			<%
			}
			%>
		</table>
	</center>

</body>
</html>
