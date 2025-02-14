package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Car {
	private String username;
	private String carModel;
	private String carType;
	private String carRegistrationNumber;
	private String serviceRequest;
	private String serviceStatus;
	private Connection con;
	
	
	
	public Car(String username, String carModel, String carType, String carRegistrationNumber, String serviceRequest,
			String serviceStatus) {
		super();
		this.username = username;
		this.carModel = carModel;
		this.carType = carType;
		this.carRegistrationNumber = carRegistrationNumber;
		this.serviceRequest = serviceRequest;
		this.serviceStatus = serviceStatus;
	}
	
	

	public Car() {
		super();
	}
	



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getCarModel() {
		return carModel;
	}



	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}



	public String getCarType() {
		return carType;
	}



	public void setCarType(String carType) {
		this.carType = carType;
	}



	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}



	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}



	public String getServiceRequest() {
		return serviceRequest;
	}



	public void setServiceRequest(String serviceRequest) {
		this.serviceRequest = serviceRequest;
	}



	public String getServiceStatus() {
		return serviceStatus;
	}



	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}



	@Override
	public String toString() {
		return "Car [username=" + username + ", carModel=" + carModel + ", carType=" + carType
				+ ", carRegistrationNumber=" + carRegistrationNumber + ", serviceRequest=" + serviceRequest
				+ ", serviceStatus=" + serviceStatus + "]";
	}
	
	
	

	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system_june","root","root");
			
		}catch(Exception e) {
			e.printStackTrace();			
		}
	}
	
	public int carDetails(){
		try {
			String s="insert into carDetails values(?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, username);
			pstmt.setString(2, carModel);
			pstmt.setString(3, carType);
			pstmt.setString(4, carRegistrationNumber);
			pstmt.setString(5, "NA");
			pstmt.setString(6, "NA");
			
			int rows=pstmt.executeUpdate();
			return rows;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int serviceRequest() {
		try {
			String s="update carDetails set service_request=?,service_status=? where username=? and car_Registration_Number=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, serviceRequest);
			pstmt.setString(2, "pending");
			pstmt.setString(3, username);
			pstmt.setString(4,carRegistrationNumber);
			
			int rows=pstmt.executeUpdate();
			return rows;
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public String serviceStatus() {
		try {
		String s="select* from carDetails where car_Registration_Number=? and username=?";
		PreparedStatement pstmt=con.prepareStatement(s);
		pstmt.setString(1, carRegistrationNumber);
		pstmt.setString(2, username);
		
		ResultSet res=pstmt.executeQuery();
		if(res.next()) {
			serviceStatus=res.getString(6);
			return serviceStatus;
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return null;
		
	}



	public ArrayList<Car> viewCustomers() {
		try {
			String s="select * from carDetails";
			PreparedStatement pstmt=con.prepareStatement(s);
			ResultSet res=pstmt.executeQuery();
			ArrayList<Car> carDetails =new ArrayList<>();
			while(res.next()) {
				username=res.getString(1);
				carModel=res.getString(1);
				carType=res.getString(1);
				carRegistrationNumber=res.getString(1);
				serviceRequest=res.getString(1);
				serviceStatus=res.getString(1);
				
				carDetails.add(new Car(username,carModel,carType,carRegistrationNumber,serviceRequest,serviceStatus));
				
			}
			return carDetails;
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
		return null;
	}



	
}
	
	
	


