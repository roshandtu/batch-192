<%@ page import="airline.*, java.util.*" %>

<%
	List<Flight> fl_list = null;
	if(request.getParameter("list-type").equals("all")) {
		fl_list = FlightDAO.getAllFlights();
	}
	else if(request.getParameter("list-type").equals("search")) {
		Flight f = new Flight();
		f.setFlight_date(request.getParameter("fdate"));
		f.setFlight_dest(request.getParameter("f_to"));
		f.setFlight_origin(request.getParameter("f_from"));
		
		fl_list = FlightDAO.searchFlight(f);	
	}
%>


<div class="flight-list ver-flex">
	
	<%
		if(fl_list != null && fl_list.size() > 0) {
			for(Flight fl : fl_list) {
			%>
				<div class="flight hor-flex">
					<h3>F# <%= fl.getFlight_num() %></h3>
					<div class="w-100 hor-flex">
						<p>From <span><%= fl.getFlight_origin() %> </span></p>
						<p>To <span><%= fl.getFlight_dest() %> </span></p>
						<p>Date <span><%= fl.getFlight_date() %> </span></p>
						<p><%= fl.getCurrency() %> <span><%= fl.getPrice() %> </span></p>
						<%
							if(request.getParameter("bookable").equals("true")) {
							%>
								<form action="Book" method="POST">
									<input type="hidden" name="b-fl-id" value="<%= fl.getFlight_id()%>">
									<input type="submit" value="Book" name="fl-book">
								</form>
							<%								
							}
						%>						
					</div>
				</div>
			<%	
			}
		}
		else {
			%>
				<p>No flights found.</p>
			<%
		}
	%>
</div>