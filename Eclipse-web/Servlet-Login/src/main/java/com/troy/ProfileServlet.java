package com.troy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet{
	
	public void goGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");;
		PrintWriter out = response.getWriter();
		out.println("<h1>Login Web Program</h1>");
		
		String username = request.getParameter("username");
				
		
	}

}
