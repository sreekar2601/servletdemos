package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Additionservlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n1=Integer.parseInt(req.getParameter("number1"));
		int n2=Integer.parseInt(req.getParameter("number2"));
		PrintWriter out=res.getWriter();
		out.println("Result = "+(n1+n2));
		
		
	}

}
