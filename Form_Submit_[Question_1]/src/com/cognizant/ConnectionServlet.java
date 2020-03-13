
package com.cognizant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Create class connection Servlet
public class ConnectionServlet extends HttpServlet {
	/**
	 * 
	 */
	// Serial ID
	private static final long serialVersionUID = 1L;
	
	
	// Get values
	String user, password, url, driver;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// get details and assign them to the respective ones
		user = config.getInitParameter("userName");
		password = config.getInitParameter("password");
		url = config.getInitParameter("url");
		driver = config.getInitParameter("driver");
		
		
		// Handle Exceptions 
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Service Initiated !");
	}
}