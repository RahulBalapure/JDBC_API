package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.product;
import com.util.MyDataBase;

public class productDao {
	public int insertPoduct(product p) {

		int check = 0;
		Connection con = new MyDataBase().getConnection();
		PreparedStatement pst = null;
		String sql = "insert into product (pname, ptype, pdescription, pprice,pimage) values (?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getPname());
			pst.setString(2, p.getPtype());
			pst.setString(3, p.getPdescription());
			pst.setDouble(4, p.getPprice());
			pst.setBytes(5, p.getPimage());
			check = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new MyDataBase().closeConnection(pst, con);
		}
		return check;
	}

	public int deleteProductById(int id) {
		int check = 0;
		Connection con = new MyDataBase().getConnection();
		PreparedStatement pst = null;
		String sql = "delete from product where pid=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			check = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new MyDataBase().closeConnection(pst, con);
		}
		return check;

	}

	public product displayProductById(int id) {
		product p = null;
		Connection con = new MyDataBase().getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "Select pid,pname,ptype,pdescription,pprice from product where pid=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				p = new product();
				p.setPid((int) rs.getObject("pid"));
				p.setPname((String) rs.getObject("pname"));
				p.setPtype((String) rs.getObject("ptype"));
				p.setPdescription((String) rs.getObject("pdescription"));
				p.setPprice((double) rs.getObject("pprice"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new MyDataBase().closeConnection(rs, pst, con);
		}

		return p;

	}

	public List<product> displayAllProduct() {
		ArrayList<product> list = new ArrayList();

		product p = null;
		Connection con = new MyDataBase().getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "Select pid,pname,ptype,pdescription,pprice from product";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				p = new product();
				p.setPid((int) rs.getObject("pid"));
				p.setPname((String) rs.getObject("pname"));
				p.setPtype((String) rs.getObject("ptype"));
				p.setPdescription((String) rs.getObject("pdescription"));
				p.setPprice((double) rs.getObject("pprice"));
				list.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new MyDataBase().closeConnection(rs, pst, con);
		}

		return list;
	}
	public int updateProduct(product p) {
		int check=0;
		
		Connection con = new MyDataBase().getConnection();
		PreparedStatement pst = null;
		String sql = "update product set pname=?, ptype=?, pdescription=?, pprice=? where pid=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getPname());
			pst.setString(2, p.getPtype());
			pst.setString(3, p.getPdescription());
			pst.setDouble(4, p.getPprice());
			pst.setInt(5, p.getPid());
			check = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new MyDataBase().closeConnection(pst, con);
		}
		
		return check;
	}
	public byte[] displayImageById(int id) {
		byte[] file=null;
		
		Connection con = new MyDataBase().getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "Select pimage from product where pid=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				file=(byte[])rs.getObject("pimage");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new MyDataBase().closeConnection(rs, pst, con);
		}
		
		return file;
		
	}

}
