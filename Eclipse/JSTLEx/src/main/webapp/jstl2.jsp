<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<html>  
<head>  
<title>Using JSTL Functions</title>  
</head>  
<body>  
  
<c:set var="String1" value="JAVATPOINT"/>  
  
<c:if test="${fn:contains(String1, 'javatpoint')}">  
   <p>Found javatpoint string<p>  
</c:if>  
  
<c:if test="${fn:contains(String1, 'JAVATPOINT')}">  
   <p>Found JAVATPOINT string<p>  
</c:if>  
 
<c:if test="${String1 eq 'JAVATPOINT'}">  
   <p>Found JAVATPOINT string<p>  
</c:if> 
  
</body>  
</html>  
