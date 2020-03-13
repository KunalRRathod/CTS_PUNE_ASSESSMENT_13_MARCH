package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Create class LoginExample 
public class LoginExample extends HttpServlet {

	// Create Conn object
	String user, password, url, driver;
	Connection conn;
	ServletContext context; // using servlet context

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
		user = context.getInitParameter("userName");
		password = context.getInitParameter("password");
		url = context.getInitParameter("url");
		driver = context.getInitParameter("driver");

		// Handle Exceptions
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			System.out.println(config + "from CS1");
			System.out.println(context + "from cs1");
		} catch (Exception e) {
			// catch block
			e.printStackTrace();
		}

	}
		// HTTP SERVLET SERVICE METHOD
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(" from service method of login Example");
		if (request.getMethod().equals("GET"))
			doGet(request, response);
		else
			doPost(request, response);
	}
		// HTTP SERVLET DO-GET METHOD
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id;
		String employeename;
		int password;
		int salary;
		
		// use Parse Int method
		id = Integer.parseInt(request.getParameter("empid"));
		employeename = request.getParameter("empname");
		password = Integer.parseInt(request.getParameter("pwd"));
		salary = Integer.parseInt(request.getParameter("salary"));
		
		// Using print writer for text output stream
		PrintWriter pw = response.getWriter();
		String insert_query = "insert into emp values(?,?,?,?)";
		try {
			PreparedStatement ps;

			ps = conn.prepareStatement(insert_query);
			ps.setInt(1, id);
			ps.setString(2, employeename);
			ps.setInt(3, password);
			ps.setInt(4, salary);

			int insert_result = ps.executeUpdate();
			if (insert_result > 0) {
				pw.write("<h1>Employee Details saved</h1>");
			} else {
				pw.write("<h1>Something went wrong</h1>");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
