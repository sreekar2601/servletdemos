package com.userapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteServlet")
public class deleteuserservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;

	public void init() {
		System.out.println("initializing addservlet...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "sreekar2001");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside post method...");
		String email = request.getParameter("email");
		try {
			Statement statement = connection.createStatement();
			// delete from user where email = 'jwil@example.com'
			int result = statement.executeUpdate("delete from user where email='" + email + "'");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<h1>User deleted</h1>");
			} else {
				out.println("<h1>User not found in the database</h1>");
			}
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
