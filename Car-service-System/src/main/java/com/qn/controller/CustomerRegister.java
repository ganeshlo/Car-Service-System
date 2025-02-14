package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qn.model.Customer;


public class CustomerRegister extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		String email=request.getParameter("email");
		
		if(password.equals(confirmPassword))
		{
			Customer c= new Customer(name,username,password,email);
			int rows=c.customerRegister();
			if(rows == 0) {
				response.sendRedirect("/Car-service-System/customerRegisterFailure.jsp");
				
			}
			else {
				response.sendRedirect("/Car-service-System/customerRegisterSuccess.jsp");
			}
		}
		else {
			response.sendRedirect("/Car-service-System/passwordMissmatch.html");
		}
	
	}
}
