package com.troy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		out.println("welcome " + name);
		
		//invisible text field
		out.println("<form action='Servlet2'>");
		out.println("<input type='hidden' name='uname' value='" +name+ "'/>");
		out.println("<input type='submt' value='submit'");
		out.println("</form>");
		out.close();
		
	}
	
}
