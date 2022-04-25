package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.student;
import com.util.MyDatabase;

public class StudentDao {
	public int insertStudent(student s) {

		int check = 0;
		if (s != null) {
			Connection con = new MyDatabase().connectionStart();
			PreparedStatement pst = null;
			String sql = "insert into student (sname, semail, spassword, sgender, saddress, shobbies,spercentage)values(?,?,?,?,?,?,?)";
			try {
				pst = con.prepareStatement(sql);

				pst.setString(1, s.getSname());
				pst.setString(2, s.getSemail());
				pst.setString(3, s.getSpassword());
				pst.setString(4, s.getSgender());
				pst.setString(5, s.getSaddress());
				pst.setString(6, s.getShobbies());
				pst.setDouble(7, s.getSpercentage());
				check = pst.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			finally {
				new MyDatabase().closeConnection(pst, con);
			}
		}
		return check;

	}

	public int deleteStudentById(int id) {

		int check = 0;
		if (id != 0) {

			Connection con = new MyDatabase().connectionStart();
			PreparedStatement pst = null;
			String sql = "DELETE FROM student WHERE sid=?;";
			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1, id);
				check = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				new MyDatabase().closeConnection(pst, con);
			}

		}
		return check;

	}

	public int UpdateStudent(student s) {

		int check=0;
		if (s != null) {
			Connection con = new MyDatabase().connectionStart();
			PreparedStatement pst = null;
			ResultSet rs=null;
			
			String sql = "Update student set sname=? , semail=? , spassword=? , sgender=? , saddress=? , shobbies=? ,spercentage=? where sid=?";
			try {
				pst = con.prepareStatement(sql);

				pst.setString(1, s.getSname());
				pst.setString(2, s.getSemail());
				pst.setString(3, s.getSpassword());
				pst.setString(4, s.getSgender());
				pst.setString(5, s.getSaddress());
				pst.setString(6, s.getShobbies());
				pst.setDouble(7, s.getSpercentage());
				pst.setInt(8, s.getSid());
				check = pst.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			finally {
				new MyDatabase().closeConnection(pst, con);
			}
		}
		return check;

	}
	public student displayStudentById(int id) {
		student s=null;
		Connection con =new MyDatabase().connectionStart();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql ="select sid, sname, semail, spassword, sgender, saddress, shobbies, spercentage from student where sid=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
			s=new student();
			s.setSid((int)rs.getInt("sid"));
			s.setSname((String)rs.getString("sname"));
			s.setSemail((String)rs.getString("semail"));
			s.setSpassword((String)rs.getString("spassword"));
			s.setSgender((String)rs.getString("sgender"));
			s.setSaddress((String)rs.getString("saddress"));
			s.setShobbies((String)rs.getString("shobbies"));
			s.setSpercentage((double)rs.getDouble("spercentage"));
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			new MyDatabase().closeConnection(rs, pst, con);
		}
		
		return s;
	}
	public List<student> displayAllStudent() {
		ArrayList <student> list=new ArrayList();
		student s1=null;
		Connection con =new MyDatabase().connectionStart();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql ="select sid, sname, semail, spassword, sgender, saddress, shobbies, spercentage from student";
		try {
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
			s1=new student();
			s1.setSid((int)rs.getInt("sid"));
			s1.setSname((String)rs.getString("sname"));
			s1.setSemail((String)rs.getString("semail"));
			s1.setSpassword((String)rs.getString("spassword"));
			s1.setSgender((String)rs.getString("sgender"));
			s1.setSaddress((String)rs.getString("saddress"));
			s1.setShobbies((String)rs.getString("shobbies"));
			s1.setSpercentage((double)rs.getDouble("spercentage"));
			list.add(s1);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			new MyDatabase().closeConnection(rs, pst, con);
		}
		
		return list;
	}
	
	public boolean greterPercent(int id) {
		boolean b=false;
		student s=new StudentDao().displayStudentById(id);
		if(s.getSpercentage()>50)
			b=true;
		
		return b;
		
	}
	

}
