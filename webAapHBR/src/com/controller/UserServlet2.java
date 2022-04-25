package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;

public class UserServlet2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("b1").equalsIgnoreCase("add")) {
			
			User u= new User();
			u.setUname(req.getParameter("uname"));
			u.setUemail(req.getParameter("uemail"));
			u.setUpassword(req.getParameter("upassword"));
			u.setUgender(req.getParameter("ugender"));
			u.setUaddress(req.getParameter("uaddress"));
			if (new UserDao().insertUser(u)>0) {
				resp.sendRedirect("index.jsp");
			}

		}
		if (req.getParameter("b1").equalsIgnoreCase("delete")) {

		}
		if (req.getParameter("b1").equalsIgnoreCase("display")) {

		}
		if (req.getParameter("b1").equalsIgnoreCase("update")) {

		}

	}
}
