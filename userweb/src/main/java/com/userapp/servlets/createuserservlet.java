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






@WebServlet("/addServlet")
public class createuserservlet extends HttpServlet {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside post method");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Statement statement = connection.createStatement();
			// insert into user values ('joe', 'wilson', 'jwil@example.com', 'test1');
			int result =statement.executeUpdate("insert into user values ('" + firstname + "', '" + lastname + "', '" + email + "', '" + password + "')");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<h1>User Created</h1>");
			} else {
				out.println("<h1>Error creating the user</h1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}

	}
}
