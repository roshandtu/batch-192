<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Passenger Details</title>
</head>
<body>
<%
	HttpSession sess = request.getSession(false);
	String pcs = (String) sess.getAttribute("pass_count");
	int pc = 0;
	if(pcs != null && !pcs.equals("")) {
		pc = Integer.parseInt(pcs);
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
        <div class="action-cont hor-center-div" id="passenger-details-cont">
        	<h1>Book Tickets</h1>
            <form action="Book" method="POST">
			<%
				if(pc == 0) {
					%>
                    <label for="passenger-count">Number of Passengers</label>
                    <input type="number" name="passenger-count" id="passenger-count"> <br>
                    <%
				}
				else {
					for(int i = 0; i < pc; i++) {
                        //passenger_fname, passenger_lname, passenger_gender;
						%>
                        <fieldset>
                            <legend>Passenger-<%= i+1 %></legend>
                            <label for="passenger-fname-<%= i %>">First Name</label>
                            <input type="text" name="passenger-fname-<%= i %>" id="passenger-fname-<%= i %>"> <br>
                            <label for="passenger-lname-<%= i %>">Last Name</label>
                            <input type="text" name="passenger-lname-<%= i %>" id="passenger-lname-<%= i %>"> <br>
                            <label for="passenger-gender-<%= i %>">Gender</label>
                            <select name="passenger-gender-<%= i %>" id="from">
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                                <option value="other">Other</option>
                            </select>
                        </fieldset>                        
						<%
					}
				}
			%>

                <div class="hor-flex w-100">   
                    <div class="w-50">
                        <input type="submit" value="Add Passengers" name="fl_book">
                    </div>                             
                </div>  
            </form>
        </div>
    </div>
</body>
</html>