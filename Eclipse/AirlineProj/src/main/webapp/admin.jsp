
<%@ page import="airline.Flight" %>
<%@ page import="airline.FlightDAO" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="js/script.js" defer></script>
    <title>Airline - Home</title>
</head>
<body>
    <div id="navbar">
        <div></div>
        <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="cancel.html">Cancel Flight</a></li>
            <li><a href="aboout.html">About Us</a></li>
            <li data-selected="true"><a href="#">Admin</a></li>
        </ul>
    </div>

<%
	boolean loggedin = false;
	String fl = request.getParameter("fl_add");
	String login = request.getParameter("login"); 
	if(login != null) {
		String u = request.getParameter("uname"),
				p = request.getParameter("pass");
		
		System.out.println(u);
		System.out.println(p);
		
		if(u.equals("admin") && p.equals("admin")) {
			Cookie c = new Cookie("uname", "admin");
			response.addCookie(c);
			loggedin = true;
		}
		
	}
	
	else if(fl != null) {
		String flnum = request.getParameter("fl_num"),
				florig = request.getParameter("fl_origin"),
				fldest = request.getParameter("fl_dest"),
				fldate = request.getParameter("fl_date"),
				curr = request.getParameter("curr"),
				fare = request.getParameter("fare");
		
		Flight f = new Flight();
		f.setFlight_num(flnum);
		f.setFlight_origin(florig);
		f.setFlight_dest(fldest);
		f.setFlight_date(fldate);
		f.setCurrency(curr);
		f.setPrice(fare);
		
		int r = FlightDAO.createFlight(f);
	}
%>


    <div class="cont" id="cont-1">
        <div id="admin-cont" class="action-cont hor-center-div">
  		<%
  			Cookie c[] = request.getCookies();
  			if(c != null) {
  				//boolean foundLogin = false;
  				for (int i = 0; i < c.length; i++) {
  					if(c[i].getName().equals("uname") && c[i].getValue().equals("admin")) {
  						loggedin = true;  						
  						break;
  					}  					
  				}
  				
  				if(loggedin) {
  					%>
						<jsp:include page="adminFunc.html"></jsp:include>
					<%
  				}
  				else {
					%>
						<jsp:include page="adminlogin.html"></jsp:include>
					<% 
				}
  			}
  			
  			else {
				%>
					<jsp:include page="adminlogin.html"></jsp:include>
				<% 
			}
  		%>      
        </div>
    </div>


    
</body>
</html>