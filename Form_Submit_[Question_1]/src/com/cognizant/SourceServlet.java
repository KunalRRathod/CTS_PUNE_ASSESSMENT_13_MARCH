package com.cognizant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Create servlet source servlet
public class SourceServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello from Source Servlet");
	}

	@Override
	public void init() throws ServletException {
		
		// Connect to database CTSPUNE 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ctspune";
			Connection conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection established");
			Statement stmt = conn.createStatement();
		} catch (Exception e) {

		}

	}
}