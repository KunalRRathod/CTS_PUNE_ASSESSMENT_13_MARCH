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

// Another example of login servlet
public class LoginExample2 extends HttpServlet {
	
	String user, password, url, driver;
	Connection conn;
	ServletContext context;
	
	// init method call invocation
	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
		user = context.getInitParameter("userName");
		password = context.getInitParameter("password");
		url = context.getInitParameter("url");
		driver = context.getInitParameter("driver");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			System.out.println(config+"from cs2");
			System.out.println(context+"from cs2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println(" from service method of loginExample2");
//		if (req.getMethod().equals("GET"))
//			doGet(req, resp);
//		else
//			doPost(req, resp);
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int id;
//		String employeename;
//		int password;
//		int salary;
//		id = Integer.parseInt(req.getParameter("empid"));
//		employeename = req.getParameter("empname");
//		password = Integer.parseInt(req.getParameter("pwd"));
//		salary = Integer.parseInt(req.getParameter("salary"));
//		PrintWriter pw = resp.getWriter();
//		String insert_query = "insert into emp values(?,?,?,?)";
//		try {
//			PreparedStatement ps;
//
//			ps = conn.prepareStatement(insert_query);
//			ps.setInt(1, id);
//			ps.setString(2, employeename);
//			ps.setInt(3, password);
//			ps.setInt(4, salary);
//
//			int insert_result = ps.executeUpdate();
//			if (insert_result > 0) {
//				pw.write("<h1>Employee Details saved</h1>");
//			} else {
//				pw.write("<h1>Something went wrong</h1>");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
