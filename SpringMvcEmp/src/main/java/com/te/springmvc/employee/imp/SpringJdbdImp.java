package com.te.springmvc.employee.imp;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.te.springmvc.employee.Dto.EmployeeDto;

public class SpringJdbdImp {
 JdbcTemplate temp;
 EmployeeDto dto ;
public void setTemp(JdbcTemplate temp) {
	this.temp = temp;
}


String q = "INSERT INTO emp VALUES(?,?)";
	public int insert(EmployeeDto dto) {
		// TODO Auto-generated method stub
		int i = temp.update(q,dto.getName(), dto.getId()); 
		
		return i;
	}
	String q1="SELECT * FROM emp";
	public List<EmployeeDto> getAll(){
		 RowMapper<EmployeeDto> rowmap = new EmpRowmapp();
		 List<EmployeeDto> emp = temp.query(q1, rowmap);
		return emp;
	}
	String q2="SELECT * FROM emp  WHERE ID=? ";
	public List<EmployeeDto> search(){
		 RowMapper<EmployeeDto> rowmap = new EmpRowmapp();
		 
//		 List<EmployeeDto> emp1 = temp.queryForObject(q2,  );
		return null;
	}
		
}
