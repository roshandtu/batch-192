<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
<style>
    * {
        font-family: Verdana, Geneva, Tahoma, sans-serif;
        font-size: 1.2em;
        transition: all 0.3s linear;
    }

    body {
        background-color: rgba(15, 77, 211, 0.377);
    }

    #calc {
        min-width: fit-content;
        max-width: 50%;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: rgba(255, 255, 255, 0.7);
        padding: 40px;
        border-radius: 10px;
        box-shadow: 10px 10px 20px rgba(25, 25, 25, 0.3);
    }

    input {
        padding: 6px;
        border: 0;        
        margin: 5px 2px;
    }

    input[type='text'] {
        border-bottom: 2px solid rgb(15, 77, 211);
        background-color: rgba(255, 255, 255, 0.2);        
    }

    input[type='text']:focus {
        border-bottom: 2px solid rgb(11, 62, 173);
        background-color: rgba(255, 255, 255, 0.7);
        outline: none;
    }

    input[type='submit'] {
        background-color: rgba(15, 77, 211, 0.5);
        width: 25%;
    }

    input[type='submit']:hover {
        background-color: rgba(15, 77, 211, 0.3);
    }

    p {
        border-top: 1px dotted rgba(25, 25, 25, 0.7);
    }
</style>
</head>
<body>
    <div id="calc">
        <h3>Calculator</h3>
        <form action="Calc.jsp" method="get">
            <input type="text" name="num1" placeholder="Number 1" autocomplete="off" /> <br>
            <input type="text" name="num2" placeholder="Number 2" autocomplete="off" /> <br>
            <input type="submit" value="+" name="bttn">
            <input type="submit" value="-" name="bttn">
            <input type="submit" value="/" name="bttn">
            <input type="submit" value="x" name="bttn">
        </form>

    <%
    	String n1 = request.getParameter("num1"),
    			n2 = request.getParameter("num2"),
    			op = request.getParameter("bttn");
    
    	if(op != null) {
    		float a = (n1 != null && n1 != "") ? Float.parseFloat(n1) : 0,
    			b = (n2 != null && n2 != "") ? Float.parseFloat(n2) : 0,
    			r = 0;
    		
    		if(op.equals("+")) {
    			r = a + b;
    		}
    		else if(op.equals("-")) {
    			r = a - b;
    		}
    		else if(op.equals("x")) {
    			r = a * b;
    		}
    		else if(op.equals("/")) {
    			try {
    				r = a / b;
    			}
    			catch (ArithmeticException e) {
    				out.println("cannot divide by zero");
    			}
    		}
    		
    		out.println("<p>" + n1 + " " + op + " " + n2 + " = " + r);
    	}
    %>
    </div>
</body>
<script>
    var u = new URL(window.location.href).searchParams;
    var a = u.get('num1'),
        b = u.get('num2');

    a = (a == null) ? 0 : a;
    b = (b == null) ? 0 : b;

    document.getElementsByName("num1")[0].value = a;
    document.getElementsByName("num2")[0].value = b;

</script>

</html>