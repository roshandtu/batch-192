<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>JSP Page</title>
     </head>
     <body> 
          <h1>Hello World!</h1>
       5+4=>   ${5+4};<br>
       5-4=>   ${5-4};<br>
       5*4=>   ${5*4};<br>
       5 / 4 =>  ${5 / 4};<br>
       5 % 4 =>   ${5 % 4};<br>
       5 == 4 => ${5 == 4};<br>
       5 eq 4 =>   ${5 eq 4};<br>
       5 gt 4 =>   ${5 gt 4};<br>
          
       10>5  =>
<core:if test="$(10>5)"></core:if>
     <core:out value="yes"></core:out>
     <br><br>

     </body>
</html>
