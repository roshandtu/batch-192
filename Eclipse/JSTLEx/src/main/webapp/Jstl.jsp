<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>  
<head>  
<title>Tag Example</title>  
</head>  
<body>  
<c:out value="${'Welcome to jstl'}"/>  
</body>  
</html>  

<!--  JSTL -jsp tag library
in this we have 5 libraries which we have to import.
1)<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> :- it is only for simple application 
where in have only input and output.
2)<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  :- in this we have some 
predefined functions and if -else condition. 
3)<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   :- in this we have change the 
format of the variables .example:- string to integer,float.
4) <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> :- it is mostly used for report 
generation.
5) <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>  :- it is mostly used to parse 
xml document.

jar file required are :- jstl-1.2,ojdbc14,servlet-api
-->