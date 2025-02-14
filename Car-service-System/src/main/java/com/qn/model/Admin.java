package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	private String adminUsername;
	private String adminPassword;
	Connection con=null;
	
	
	public Admin(String adminUsername, String adminPassword) {
		super();
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}

	public Admin() {
		super();
	}
	

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminUsername=" + adminUsername + ", adminPassword=" + adminPassword + "]";
	}
	
	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system_june","root","root");
			
		}catch(Exception e) {
			e.printStackTrace();			
		}
	}
	
	 public int adminLogin() {
		   try {
			   String s="select*from admin where admin_user_name=?";
			   PreparedStatement pstmt=con.prepareStatement(s);
			   pstmt.setString(1, adminUsername);
			   
			   ResultSet res=pstmt.executeQuery();
			   if(res.next()) {
				   if(adminPassword.equals(res.getString(2))){
					   
					   
				   return 1;//valid username and password
			   }
				   else {
					   return 0;//invalid password
				   }
			   }
			   else {
				   return -1; //invalid username
				   
			   }
			   
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		return 0;
	   }
		
		

}
