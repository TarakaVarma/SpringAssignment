 package com.te.springmvc.employee.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.te.springmvc.employee.Dto.EmployeeDto;
@Component
public class ImplementationDao {
	
	public boolean insert(EmployeeDto emp) {
		boolean insert =false;
		String url="jdbc:mysql://localhost:3306/user";
		String u="root";
		String p="root";
	    Connection c;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			c = DriverManager.getConnection(url,u,p);
			PreparedStatement psp = c.prepareStatement("INSERT INTO emp(NAME,ID) values(?,?)");
			psp.setString(1,emp.getName() );
		      psp.setString(2,emp.getId() );
		      
		      psp.executeUpdate();
		      insert=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insert;	
	}
	public void delete(EmployeeDto emp) {
		
		String url="jdbc:mysql://localhost:3306/user";
		String u="root";
		String p="root";
	    Connection c;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			c = DriverManager.getConnection(url,u,p);
			PreparedStatement psp = c.prepareStatement("DELETE FROM emp WHERE ID=?");
//			psp.setString(1,emp.getName() );
		      psp.setString(1,emp.getId() );
		      
		      psp.executeUpdate();
		      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
public void update(EmployeeDto emp) {
		String url="jdbc:mysql://localhost:3306/user";
		String u="root";
		String p="root";
	    Connection c;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			c = DriverManager.getConnection(url,u,p);
			PreparedStatement psp = c.prepareStatement("UPDATE emp SET NAME=? WHERE ID=?");			
			psp.setString(1,emp.getName() );
		      psp.setString(2 ,emp.getId() );
		      psp.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
public boolean authntication(EmployeeDto emp) {
	 boolean update=false;
	String url="jdbc:mysql://localhost:3306/user";
	String u="root";
	String p="root";
    Connection c;
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		c = DriverManager.getConnection(url,u,p);
		PreparedStatement psp = c.prepareStatement("SELECT NAME,ID FROM emp  WHERE NAME=? AND ID=? ");			
		psp.setString(1,emp.getName() );
	      psp.setString(2 ,emp.getId() );
	      
	     ResultSet r =  psp.executeQuery();
	     r.next();
	     if(r.getString(1).equals(emp.getName()) && r.getString(2).equals(emp.getId())) {
	    	 update=true;
	     }     
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return update;	
}
}
