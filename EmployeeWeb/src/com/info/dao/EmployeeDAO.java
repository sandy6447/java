package com.info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.info.factory.DBConnection;
import com.info.model.Employee;

public class EmployeeDAO {

	Connection connection;
	public EmployeeDAO(){
		
		connection= DBConnection.createConnection();
	}
	
	 public  int addEmployee(int no ,String name, String gender,double sal, String uname, String pwd) {
		 int result=0;
		 try {
			 
			 String query = "insert into employee values(?,?,?,?,?,?)";
			 PreparedStatement pstatement = connection.prepareStatement(query);
			 pstatement.setInt(1, no);
			 pstatement.setString(2, name);
			 pstatement.setString(3, gender);
			 pstatement.setDouble(4, sal);
			 pstatement.setString(5, uname);
			 pstatement.setString(6, pwd);
			 result = pstatement.executeUpdate();
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return result;
	 }
	 

	public boolean userDetails(Employee employee) {
		 boolean flag =false;
		 try {
			 String query = "select * from employee where username=? and password =?";
			 PreparedStatement pstatement = connection.prepareStatement(query);
			 pstatement.setString(1, employee.getUsername());
			 pstatement.setString(2, employee.getPassword());
			ResultSet result = pstatement.executeQuery();
			 flag =result.next();
		 } catch(Exception e){
				 e.printStackTrace();
			 } 
		 
		 return flag;
	 }
	public List<Employee> displayList() {
		List<Employee> allEmployee = new ArrayList<>();
		try {
		String query = "select * from employee";
		PreparedStatement pStatement = connection.prepareStatement(query);
		ResultSet result = pStatement.executeQuery();
		
		while(result.next()) {
			Employee employee = new Employee();
		
			employee.setEno(result.getInt("eno"));
			employee.setEname(result.getString("ename"));
			
			allEmployee.add(employee);
		
			
		}
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return allEmployee;
	}

	public List<Employee> getDetails(int eno) {
		List<Employee> allEmployee = new ArrayList<>();
		try
		{
		String query = "select * from employee e where e.eno=?";
		PreparedStatement pStatement = connection.prepareStatement(query);
		pStatement.setInt(1, eno);
		ResultSet result = pStatement.executeQuery();
		
		while(result.next()) {
		Employee e = new Employee();
		
			e.setEno(result.getInt("eno"));
			e.setEname(result.getString("ename"));
			e.setGender(result.getString("gender"));
			e.setSalary(result.getDouble("salary"));
			e.setUsername(result.getString("username"));
			
			allEmployee.add(e);
			
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return allEmployee;
	}
	public int removeEmployee(Employee employee) {

		int result=0;
		try {
		String  query = "delete * from employee where eno=?";
		PreparedStatement pStatement= connection.prepareStatement(query);
		pStatement.setString(1, employee.getUsername());
		result= pStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}return result;
		}
	}


