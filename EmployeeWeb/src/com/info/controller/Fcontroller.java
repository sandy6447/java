package com.info.controller;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("*.htm")
public class Fcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			EmployeeController controller = new EmployeeController();
			String action = request.getServletPath();
			if(action.equals("/Register.htm"))
			{
				controller.registerEmployee(request, response);
				}
			else if(action.equals("/Login.htm"))
			{
				controller.loginEmployee(request, response);
			}
			else if(action.equals("/Details.htm"))
			{
				controller.employeeDetails(request, response);
			}
			else if(action.equals("/ViewList.htm")) {
				controller.employeeList(request, response);
			}
	}
}