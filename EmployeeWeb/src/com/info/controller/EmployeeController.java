package com.info.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.dao.EmployeeDAO;
import com.info.model.Employee;

public class EmployeeController {

	
	public void registerEmployee (HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{

		int no = Integer.parseInt(request.getParameter("eno"));
		String name = request.getParameter("ename");
		String gender =request.getParameter("gender");
		double sal = Double.parseDouble(request.getParameter("salary"));
		String uname = request.getParameter("username");
		String pwd =request.getParameter("password");
		
		EmployeeDAO eDao = new EmployeeDAO();
		int result =eDao.addEmployee(no, name, gender,sal, uname, pwd);
		
		RequestDispatcher dispatcher;
		
		if(result > 0 ) {
			request.setAttribute("message",no + "Employee Details Updated");
			dispatcher = request.getRequestDispatcher("ViewList.htm");
			dispatcher.forward(request,response);
		}
		else {
			request.setAttribute("message",no+"Details not Updated");
		dispatcher = request.getRequestDispatcher("Primary.jsp");
		dispatcher.forward(request,response);
		}
	}
	
	public void loginEmployee (HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		String uname = request.getParameter("username");
		String  pwd = request.getParameter("password");
		
		Employee employee = new Employee();
		
		employee.setUsername(uname);
		employee.setPassword(pwd);
		EmployeeDAO eDAO= new EmployeeDAO();
		boolean flag = eDAO.userDetails(employee);
		
		RequestDispatcher dispatcher;
		
		if(flag == true) {
		dispatcher = request.getRequestDispatcher("ViewList.htm");                
		dispatcher.forward(request,response);
		}
		else
		{
			request.setAttribute("message","Invalid Credentials \n Please try again");
			dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request,response);
		}
	}
	
	public void employeeDetails (HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		int eno = Integer.parseInt( request.getParameter("eno"));
		EmployeeDAO eDao = new EmployeeDAO();
		List<Employee> allEmployee =eDao.getDetails(eno);
		request.setAttribute("list",allEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Details.jsp");
		dispatcher.forward(request,response);
		
		}	
		
		public void employeeList (HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
			EmployeeDAO eDao = new EmployeeDAO();
			List<Employee> allEmployee =eDao.displayList();
			
			request.setAttribute("list",allEmployee);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewList.jsp");
			dispatcher.forward(request,response);
			
		}	
}
