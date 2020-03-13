package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Class Source Servlet 
@WebServlet("/SourceServlet")
public class SourceServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("from doGet of Source Servlet");
		
		
		String customername = req.getParameter("username");
		int termInYears = Integer.parseInt(req.getParameter("term"));
		int premiumamount = Integer.parseInt(req.getParameter("premium"));
		req.setAttribute("cname", customername);
		req.setAttribute("noOfYears", termInYears);
		req.setAttribute("premium", premiumamount);
		
		System.out.println("Your paid amount =" + premiumamount * termInYears);
		
		// Get Printwriter
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>Assured amount &nbsp; &nbsp;" + (premiumamount * termInYears) + "</h1>");
		
		//Can Redirect here 
			//	resp.sendRedirect("https://github.com/KunalRRathod/CTS_PUNE_ASSESSMENT_13_MARCH");
		RequestDispatcher dispatch = req.getRequestDispatcher("/http://localhost:8080/WebApp2/login.html");
		dispatch.include(req, resp);

	}

}
