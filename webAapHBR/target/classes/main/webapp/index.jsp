<html>
<body>
<center>
		<h3>User From</h3>
		<hr>
		<form action="UserServlet2" method="post">
			<table cellpadding="2" width="20%" bgcolor="99FFFF" align="center"
				cellspacing="2">
				<tr>
					<td align="right">Id :</td>
					<td><input type="text" name="uid" value="0"></td>
				</tr>
				<tr>
					<td align="right">Name :</td>
					<td><input type="text" name="uname" placeholder=""></td>
				</tr>
				<tr>
					<td align="right">Email :</td>
					<td><input type="email" name="uemail"
						placeholder="Enter your Email"></td>
				</tr>
				<tr>
					<td align="right">Password :</td>
					<td><input type="password" name="epassword"
						placeholder="Enter your Password"></td>
				</tr>
				<tr>
					<td align="right">Gender :</td>
					<td><input type="radio" name="ugender" value="Male">Male
						<input type="radio" name="ugender" value="Female">Female <input
						type="radio" name="ugender" value="Other">Other</td>
				</tr>
				<tr>
					<td align="right">Address :</td>
					<td><textarea rows="5" cols="15" name="uaddress"></textarea></td>
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
			<font>User List</font>
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
				
			</tr>
			
		</table>
	</center>

</body>
</html>
