<%@ page import="java.sql.*" %>

<%
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","mphasis","1234");
	
	String c = request.getParameter("category");
	
	if(c != null) {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM proj1_products WHERE LOWER(category)=LOWER(?)");
		ps.setString(1, c);
		if(ps.execute()) {
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
			%>
				<div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                    <div class="brand-box">
                        <i><img src="icon/<%= rs.getString("image") %>"/></i>
                        <h3><%= rs.getString("name") %></h3>
                        <h4>$<span class="nolmal"><%= rs.getString("price") %></span></h4>
                    </div>
                    <a class="buynow" href="addCart?pid=<%= rs.getString("id") %>">Add to cart</a>
                </div>
			<%
			}
		}
	}
	
	con.close();
	
}
catch (Exception e) {
	e.printStackTrace();
}

%>