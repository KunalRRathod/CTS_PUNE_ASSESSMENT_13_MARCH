package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Create class Target Servlet 
@WebServlet("/TargetServlet")
public class TargetServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("from doGet of Target Servlet");
		
		String customer =(String) req.getAttribute("cname");
		int year=(Integer)req.getAttribute("noOfYears");
		int pre=(Integer)req.getAttribute("premium");
		double sumAssured=(pre * year)+(pre* year)* 20/100;
		
		System.out.println("Sum assured after maturity = "+sumAssured);
		
		// Get Printwriter 
		PrintWriter pw=resp.getWriter();
		pw.write("<h1>Sum assured after maturity &nbsp; &nbsp;"+(sumAssured)+"</h1>");
		
	}

}
