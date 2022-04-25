package com.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.model.student;

public class StudentServlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("b1").equals("Add")) {
			student s = new student();
			s.setSname(req.getParameter("sname"));
			s.setSemail(req.getParameter("semail"));
			s.setSpassword(req.getParameter("spassword"));
			s.setSgender(req.getParameter("sgender"));
			s.setSaddress(req.getParameter("saddress"));
			s.setSpercentage(Double.parseDouble(req.getParameter("spercentage")));
			s.setShobbies(Arrays.toString(req.getParameterValues("shobbies")).toString());
			if (new StudentDao().insertStudent(s) > 0)
				resp.sendRedirect("index.jsp");

		}
		if (req.getParameter("b1").equals("Delete")) {

			if (new StudentDao().deleteStudentById(Integer.parseInt(req.getParameter("sid"))) > 0) {
				resp.sendRedirect("index.jsp");
			}
		}
		if (req.getParameter("b1").equals("Display")) {

			student s =new StudentDao().displayStudentById(Integer.parseInt(req.getParameter("sid")));
				if(s!=null) {
					req.setAttribute("student", s);
					req.getRequestDispatcher("second.jsp").forward(req, resp);
				}else {
					resp.sendRedirect("index.jsp");
				}
			
		}
		if (req.getParameter("b1").equals("Update")) {
			student s = new student();
			s.setSid(Integer.parseInt(req.getParameter("sid")));
			s.setSname(req.getParameter("sname"));
			s.setSemail(req.getParameter("semail"));
			s.setSpassword(req.getParameter("spassword"));
			s.setSgender(req.getParameter("sgender"));
			s.setSaddress(req.getParameter("saddress"));
			s.setSpercentage(Double.parseDouble(req.getParameter("spercentage")));
			s.setShobbies(Arrays.toString(req.getParameterValues("shobbies")).toString());
			if (new StudentDao().UpdateStudent(s) > 0)
				resp.sendRedirect("index.jsp");
			else {
				System.out.println("data not found");
			}

		}

	}

}
