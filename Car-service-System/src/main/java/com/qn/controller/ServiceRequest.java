package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Car;




public class ServiceRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serviceRequest=request.getParameter("serviceRequest");
		String carRegistrationNumber=request.getParameter("carRegistrationNumber");
		Car c=new Car();
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		
		c.setServiceRequest(serviceRequest);
		c.setUsername(carRegistrationNumber);
		c.setUsername(username);
		
		
		int status=c.serviceRequest();
		
		if(status==0) {
			response.sendRedirect("/Car-service-System/serviceRequestFailure.jsp");
		}
		else {
			response.sendRedirect("/Car-service-System/serviceRequestSucces.jsp");

		}
		
		
	}

}
