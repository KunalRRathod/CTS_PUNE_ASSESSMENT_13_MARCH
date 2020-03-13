package com.cts;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/RequestHandlerServlet")
public class FirstFilter implements Filter {
String name,name2;
	public FirstFilter() {
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		name=request.getParameter("unique");
		name2=name.toUpperCase();
		if(name.equals(name2))
		{
			chain.doFilter(request, response);
		}
		else
		{
			response.getWriter().write("<h1>Invalid username</h1>");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("from init method  of first filter ");

	}
}
