<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="js/script.js" defer></script>
    <title>Search</title>
</head>
<body>
<%
	HttpSession sess = request.getSession();
	String tcs = (String) sess.getAttribute("t_count");
	int tc = 1;
	if(tcs != null) {
		tc = Integer.parseInt(tcs);
	}
	String from = request.getParameter("from").toUpperCase(), 
			to = request.getParameter("to").toUpperCase(),
			fdate = request.getParameter("dep-date"),
			retdate = request.getParameter("ret-date");
	
	if(request.getParameter("trip").equals("round") && tc == 1) {
		from = request.getParameter("to").toUpperCase();
		to = request.getParameter("from").toUpperCase();
		fdate = retdate;
	}
	
%>

    <div id="navbar">
        <div></div>
        <ul>
            <li data-selected="true"><a href="index.html">Home</a></li>
            <li><a href="cancel.html">Cancel Flight</a></li>
            <li><a href="aboout.html">About Us</a></li>
            <li><a href="admin.jsp">Admin</a></li>
        </ul>
    </div>

    <div class="cont" id="cont-1">
        <div id="flight-list-cont" class="action-cont hor-center-div">
        	<h1><%= from %> to <%= to %></h1>
        	<jsp:include page="flightlist.jsp">
            	<jsp:param value="search" name="list-type"/>
            	<jsp:param value="true" name="bookable"/>
            	<jsp:param value="<%= from %>" name="f_from"/>
            	<jsp:param value="<%= to %>" name="f_to"/>
            	<jsp:param value="<%= fdate %>" name="fdate"/>
            </jsp:include>
        </div>
        
        <%
        	if(request.getParameter("trip").equals("round") && tc == 2) {
        		//display return flights
        		%>
        			<div id="flight-list-cont" class="action-cont hor-center-div">
			        	<h1>Return Flights (<%= to %> to <%= from %>)</h1>
			        	<jsp:include page="flightlist.jsp">
			            	<jsp:param value="search" name="list-type"/>
			            	<jsp:param value="false" name="bookable"/>
			            	<jsp:param value="<%= to %>" name="f_from"/>
            				<jsp:param value="<%= from %>" name="f_to"/>
            				<jsp:param value="<%= retdate %>" name="fdate"/>
			            </jsp:include>
			        </div>
        		<%
        	}
        %>
    </div>
</body>
</html>