package com.userapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readServlet")
public class readuserservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
       
	public void init(ServletConfig sc) {
		System.out.println("initializing addservlet...");
		ServletContext context=sc.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dburl"),context.getInitParameter("dbname"),context.getInitParameter("dbpwd"));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doGet...");
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user");
			PrintWriter out = response.getWriter();
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>First Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>Email</th>");
			out.println("</tr>");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getString(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			if (connection != null) {
				connection.close();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}