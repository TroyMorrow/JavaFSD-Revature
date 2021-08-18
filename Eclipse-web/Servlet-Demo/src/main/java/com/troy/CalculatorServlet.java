package com.troy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");;
		PrintWriter out = response.getWriter();
		out.println("<h1>Calculator Web Program</h1>");
		
		double num1 = Double.parseDouble(request.getParameter("num1"));
		double num2 = Double.parseDouble(request.getParameter("num2"));
		String math = request.getParameter("math");
		
		if (math.equals("add") || math.equals("+")){
			out.print("<h2>" + (num1 + num2) +"</h2>");
		} else if (math.equals("subtract") || math.equals("-")) {
			out.print("<h2>" + (num1 - num2) +"</h2>");
		}else if (math.equals("multiply") || math.equals("*")) {
			out.print("<h2>" + (num1 * num2) +"</h2>");
		}else if (math.equals("divide") || math.equals("/")) {
			out.print("<h2>" + (num1 / num2) +"</h2>");
		}else {
			out.println("Invalid mathicatical expression");
		}
		
	}
	
}
