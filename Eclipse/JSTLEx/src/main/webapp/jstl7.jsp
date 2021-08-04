<%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
  
<html>  
<head>  
<title>sql:query Tag</title>  
</head>  
<body>  
   
<sql:setDataSource var="db" driver="oracle.jdbc.driver.OracleDriver"  
     url="jdbc:oracle:thin:@localhost:1521:XE"  
     user="mphasis"  password="1234"/>  
  
<sql:query dataSource="${db}" var="rs">  
SELECT * from employee
</sql:query>  
   
<table border="2" width="100%">  
<tr>  
<th>EmpNo</th>  
<th>First Name</th>  
<th>Address</th>  

</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.accno}"/></td>  
<td><c:out value="${table.name}"/></td>  
<td><c:out value="${table.address}"/></td>  
</tr>  
</c:forEach>  
</table>  
  
</body>  
</html>  