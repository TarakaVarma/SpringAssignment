<%@page import="com.te.springmvc.employee.Dto.EmployeeDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%  EmployeeDto emp1 = (EmployeeDto) request.getAttribute("EMP"); %>
<body>
  <%=emp1.getId()%>
<%=emp1.getName() %> Login sucess ......!
 <form action="./log">  
 <input  type="submit"  value="Logout">
  </form>

</body>
</html>