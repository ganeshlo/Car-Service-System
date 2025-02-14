package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Car;


public class CarDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String carModel=request.getParameter("car_model");
	String carType=request.getParameter("car_type");
	String carRegistrationNumber=request.getParameter("car_registration_number");
	
	HttpSession session=request.getSession();
	String username=(String)session.getAttribute("username");
	
	Car c=new Car();
	c.setUsername(username);
	c.setCarModel(carModel);
	c.setCarType(carType);
	c.setCarRegistrationNumber(carRegistrationNumber);
	int status=c.carDetails();
	if(status == 0) {
		response.sendRedirect("/Car-service-System/carDetailsFailure.jsp");
	}
	else {
		response.sendRedirect("/Car-service-System/carDetailsSuccess.jsp");
	}
	
}
	
	
}
