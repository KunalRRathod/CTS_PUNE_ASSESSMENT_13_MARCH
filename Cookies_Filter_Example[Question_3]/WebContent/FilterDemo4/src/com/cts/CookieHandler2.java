package com.cts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieHandler2")
public class CookieHandler2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Cookie cokkies[] = req.getCookies();
		if (cokkies != null) {
			for (Cookie cookie2 : cokkies) {
				out.write("<h2>" + cookie2.getName() + cookie2.getValue() + "</h2>");
			}
		} else {
			out.write("<h1>No cookies are associated </h1>");
		}
	}
}
