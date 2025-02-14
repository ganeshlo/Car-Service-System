package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Customer;


public class CustomerLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Customer c =new Customer();
		c.setUsername(username);
		c.setPassword(password);
		int status=c.customerLogin();
		
		if(status == 1){
			String name=c.getName();
			HttpSession session=request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("username", username);
			
			response.sendRedirect("/Car-service-System/customerLoginSuccess.jsp");
			
		}
		else if(status == -1){
			response.sendRedirect("/Car-service-System/invalidCustomerUsername.jsp");
			
		}
		else {
			response.sendRedirect("/Car-service-System/invalidCustomerPassword.jsp");
			
		}
		
		
		
	}
	
	

}
