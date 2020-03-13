package com.cts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestHandlerServlet")
public class RequestHandlerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>Welcome to the home page</h1>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ccd=req.getParameter("unique");
		String pass=req.getParameter("pwd");
		Cookie cookie=new Cookie(ccd, pass);
		cookie.setMaxAge(24*365*7);
		resp.addCookie(cookie);
		RequestDispatcher rd=req.getRequestDispatcher("/CookieHandler2");
		rd.forward(req, resp);
		
	}
}
