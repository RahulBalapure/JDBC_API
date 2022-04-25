<%@page import="com.dao.productDao"%>
<%@page import="com.model.product"%>


<html>
<body>


	<center>
		<h3>Product Display</h3>
		<hr>
		<form action="ProductServlete" method="post" enctype="multipart/form-data">
			<table cellpadding="2" width="25%" bgcolor="99FFFF" align="center"
				cellspacing="2">
				<tr>
					<td align="center">Product ID :</td>
					<td><input type="text" name="pid" value="0"></td>
				</tr>
				<tr>
					<td align="center">Product Name :</td>
					<td><input type="text" name="pname"></td>
				</tr>
				<tr>
					<td align="center">Product Type :</td>
					<td><select name="ptype">
							<option value="Fashion">Fashion</option>
							<option value="Mobile and Accessories">Mobile and Accessories</option>
							<option value="Grocery">Grocery</option>
							<option value="Electronics and Home Appliances">Electronics and Home Appliances</option>
							<option value="Cosmatic">Cosmatic</option>
							<option value="Health and Medicine">Health and Medicine</option>

					</select></td>
				</tr>
				<tr>
					<td align="center">Product Description :</td>
					<td><textarea rows="5" cols="15" name="pdescription"></textarea></td>
				</tr>
				
				
				<tr>
				<td>Product Image :</td>
				<td><input type="file" name="pimage">
				</td>
				</tr>
				
				
				
				<tr>
					<td align="center">Product price :</td>
					<td><input type="text" name="pprice" value="0"></td>
				</tr>
				<tr>

					<td colspan="2" align="center"><input type="submit" name="b1"
						value="Add"> <input type="submit" name="b1"
						value="Delete"> <input type="submit" name="b1"
						value="Display"></td>
				</tr>

			</table>
			</from>
			<hr>
			<h3>Product List</h3>
			<hr>

			<table cellpadding="3" border="2" cellspacing="2">
				<tr bgcolor="MediumSpringGreen">
					<td align="center" ><b>ID</b></td>
					<td align="center"><b>Product Image</b></td>
					<td align="center"><b>Product Name</b></td>
					<td align="center"><b>Product Type</b></td>
					<td align="center"><b>Product description</b></td>
					<td align="center"><b>Product Price</b></td>
				</tr>
				<%int c=0;
				double tprice=0; %>				<%
				for (product p : new productDao().displayAllProduct()) {
					c++;
					tprice+=p.getPprice();
				%>
				<tr>
					<td align="center" bgcolor="yellow"><a href="ProductServlete?b1=Display&pid=<%=p.getPid()%>"><%=p.getPid()%></a></td>
					<td><a href="ProductServlete?b1=Display&pid=<%=p.getPid()%>"><img src="viewimage.jsp?pid=<%=p.getPid()%>" height="100" width="100"></a></td>
					<td align="center"><a href="ProductServlete?b1=Display&pid=<%=p.getPid()%>"><%=p.getPname()%></a></td>
					<td align="center"><a href="ProductServlete?b1=Display&pid=<%=p.getPid()%>"><%=p.getPtype()%></a></td>
					<td align="center" width="200"><a href="ProductServlete?b1=Display&pid=<%=p.getPid()%>"><%=p.getPdescription()%></a></td>
					<td align="center"><a href="ProductServlete?b1=Display&pid=<%=p.getPid()%>"><%=p.getPprice()%></a></td>
					<td ><a href="ProductServlete?b1=Delete&pid=<%=p.getPid()%>"> delete </a></td>
				</tr>
				<%
				}
				%>
				<tr><td colspan="6" align="right"><b> Total Product :<%=c %>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Total Price : <%=tprice%> &nbsp;</b> </td></tr>

			</table>
	</center>
</body>
</html>