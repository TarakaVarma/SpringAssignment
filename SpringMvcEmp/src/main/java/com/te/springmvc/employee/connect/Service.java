package com.te.springmvc.employee.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.te.springmvc.employee.Dto.EmployeeDto;
import com.te.springmvc.employee.imp.ImplementationDao;
import com.te.springmvc.employee.imp.SpringJdbdImp;


@Component
public class Service {
	
	@Autowired
	ImplementationDao da;
	
	
	ApplicationContext app = new ClassPathXmlApplicationContext("com\\te\\springmvc\\employee\\connect\\Config.xml");
	 SpringJdbdImp s=    app.getBean("jdbcimp", SpringJdbdImp.class );
	
	
	public boolean insert(EmployeeDto emp){
		if(emp!=null) 
//		da.insert(emp);
			if(s.insert(emp)==1) {
				return true;
			}
		return false;		
	}
	public void delData(EmployeeDto emp){
		da.delete(emp);
			
	}
	
	public void update(EmployeeDto emp) {
//		da.update(emp);
	}
	public boolean signIn(EmployeeDto emp) {
		
	return da.authntication(emp);	 
	}
	
	public List<EmployeeDto>getAll(){
		return s.getAll();
	}
	
	public List<EmployeeDto> Search(){
		return s.search();
	}
	
	
	
}
