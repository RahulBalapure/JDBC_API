package com.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.dao.productDao;
import com.model.product;
@MultipartConfig(maxFileSize = 999999999,maxRequestSize = 999999999)

public class ProductServlete extends HttpServlet {
	@Override
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("b1").equalsIgnoreCase("Delete")) {

			if (new productDao().deleteProductById(Integer.parseInt(req.getParameter("pid"))) > 0)
				resp.sendRedirect("index.jsp");
		}
		if (req.getParameter("b1").equalsIgnoreCase("display")) {

			product p=new productDao().displayProductById(Integer.parseInt(req.getParameter("pid")));
			if(p!=null) {
				
				req.setAttribute("product", p);
				req.getRequestDispatcher("second.jsp").forward(req, resp);
				
			}else {
				resp.sendRedirect("index.jsp");
			}
		}
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("b1").equals("Add")) {

			product p = new product();
			p.setPname(req.getParameter("pname"));
			p.setPtype(req.getParameter("ptype"));
			p.setPdescription(req.getParameter("pdescription"));
			p.setPprice(Double.parseDouble(req.getParameter("pprice")));
			//Part filePart=req.getPart("pimage");
			//InputStream input=filePart.getInputStream();
			//byte[] image=IOUtils.toByteArray(input);
			p.setPimage(IOUtils.toByteArray(req.getPart("pimage").getInputStream()));

			if (new productDao().insertPoduct(p) > 0) {
				
				resp.sendRedirect("index.jsp");
			}
		}
		if (req.getParameter("b1").equals("Delete")) {

			if (new productDao().deleteProductById(Integer.parseInt(req.getParameter("pid"))) > 0)
				resp.sendRedirect("index.jsp");
		}
		if (req.getParameter("b1").equals("Display")) {

			product p=new productDao().displayProductById(Integer.parseInt(req.getParameter("pid")));
				if(p!=null) {
					
					req.setAttribute("product", p);
					req.getRequestDispatcher("second.jsp").forward(req, resp);
					
				}else {
					resp.sendRedirect("index.jsp");
				}
			
		}
		if(req.getParameter("b1").equalsIgnoreCase("Update")) {
			
			product p = new product();
			p.setPid(Integer.parseInt(req.getParameter("pid")));
			p.setPname(req.getParameter("pname"));
			p.setPtype(req.getParameter("ptype"));
			p.setPdescription(req.getParameter("pdescription"));
			p.setPprice(Double.parseDouble(req.getParameter("pprice")));
			if(new productDao().updateProduct(p)>0) {
				resp.sendRedirect("index.jsp");
			}
			
		}

	}
}
