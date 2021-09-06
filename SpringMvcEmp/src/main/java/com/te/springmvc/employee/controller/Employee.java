package com.te.springmvc.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.te.springmvc.employee.Dto.EmployeeDto;
import com.te.springmvc.employee.connect.Service;

@Controller
public class Employee{
	@Autowired
	Service sc;
    @GetMapping("/add")
	public String getData() {
		return  "Data";
		
	}
    
    @GetMapping("/delete")
    public String getDelete() {
    	return "delete";
    }
    @GetMapping("/signing")
    public String getSign() {
    	return "SignIn";
    }
    @GetMapping("/update")
    public String getUpdate() {
    	return "Update";
    }
    
    @PostMapping("/insert")
    public String display(EmployeeDto emp, ModelMap map, HttpServletRequest req) {
    	if(sc.insert(emp)) {
    		map.addAttribute("EMP",emp);
        	
    		return "Display";
    	}
		return "Invalid data";	
    }
    @PostMapping("/deleterec")
    public String delete(EmployeeDto emp, ModelMap map, HttpServletRequest req) {
    	sc.delData(emp);

    	map.addAttribute("EMP",emp);
    	
		return "Deleterecord";
    	
    }
    @GetMapping("/get")
    public String display(ModelMap map, EmployeeDto dto) {
    	
        List<EmployeeDto> elist= sc.getAll();
        if(elist!=null) {
        	map.addAttribute("data", elist);
        }
        else {
        	map.addAttribute("msg", "no data");
        }
    	
		return "AllData";
    	
    }
    
    @PostMapping("/updaterec")
    public String update(EmployeeDto emp, ModelMap map, HttpServletRequest req) {
    	sc.update(emp);

    	map.addAttribute("EMP",emp);
    	
		return "Updaterec";
    	
    }
    @PostMapping("/sign")
    public String  auth(EmployeeDto emp, ModelMap map, HttpServletRequest req) {
    	boolean tk =sc.signIn(emp);
    	map.addAttribute("EMP",emp);
    	if(tk) {
    		return "Login";
    	}
		return "Error";
    	
    }
    @GetMapping("/log")
    public String logout() {
		return "SignIn";
    	
    }
	
}
