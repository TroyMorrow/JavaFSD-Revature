package com.troy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html; charset = UTF-8");
		try (PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Servlet State Management</Title>");
			out.println("</Head>");
			out.println("<Body>");
			out.println("<h1>Login Web Program</h1>");
		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
		
			Cookie c = new Cookie("username", username);
		
			if (username != "MoyTrorrow") {
				out.println("Invalid username credentials");
			} else if (password != "password") {
				out.println("Invalid password");
			} else {
				response.addCookie(c);
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Welcome Back');");
				out.println("<h1><a href= 'servlet2'>Profile</a></h1>");
				out.println("location='Index.html';");
				out.println("</script>");
			
				out.println("</Body>");
				out.println("</HTML>");
			}
		}
	}
}
