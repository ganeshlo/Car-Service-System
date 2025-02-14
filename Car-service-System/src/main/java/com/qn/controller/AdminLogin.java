package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Admin;




public class AdminLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminUsername=request.getParameter("adminUsername");
		String adminPassword=request.getParameter("adminPassword");
		
		Admin c =new Admin();
		c.setAdminUsername(adminUsername);
		c.setAdminPassword(adminPassword);
		int status=c.adminLogin();
		
		if(status == 1){
			
			
			response.sendRedirect("/Car-service-System/adminLoginSuccess.jsp");
			
		}
		else if(status == -1){
			response.sendRedirect("/Car-service-System/invalidAdminUsername.jsp");
			
		}
		else {
			response.sendRedirect("/Car-service-System/invalidAdminPassword.jsp");
			
		}
		
		
		
	}
	
	

}
