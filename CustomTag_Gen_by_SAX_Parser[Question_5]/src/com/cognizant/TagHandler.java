package com.cognizant;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

// Create Tag Handler
public class TagHandler extends TagSupport {
	@Override
	public int doStartTag() throws JspException {

		System.out.println("from doStartTag()");

		JspWriter out = pageContext.getOut();
		try {
			out.write("<h1>" + new Date() + "</h1>");
		} catch (IOException e) {

			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {

		System.out.println("from doEndTag()");
		return EVAL_PAGE;
	}

}
