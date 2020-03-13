package com.cognizant;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Create servlet for validation 
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("from init");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" from service method");
		if(req.getMethod().equals("GET"))
			doGet(req, resp);
		else
			doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("from doGet method");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("from do post method");
	}
}
