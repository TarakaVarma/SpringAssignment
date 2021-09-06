package com.te.springmvc.employee.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.te.springmvc.employee.Dto.EmployeeDto;

public class EmpRowmapp  implements RowMapper<EmployeeDto> {

	@Override
	public EmployeeDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		EmployeeDto e = new EmployeeDto();
		e.setName(rs.getString(1));
		e.setId(rs.getString(2));
		return e;
	}
	 
	
}
