package airline;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mphasis","1234");
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return con;
	}
	
	public static int createFlight(Flight f) {
		String q = "INSERT INTO flight VALUES (seq_flight.NEXTVAL, UPPER(?), UPPER(?), UPPER(?), TO_DATE(?,'YYYY/MM/DD'))";
		//id, origin, dest, fl_num, date
		String q2 = "INSERT INTO fare VALUES (seq_fare.NEXTVAL, UPPER(?), ?, ?)";
		//id, curr, fare, fl_id
		int ret = 0;
		try {
			Connection con = FlightDAO.getConnection();
			PreparedStatement st = con.prepareStatement(q);
			st.setString(1, f.getFlight_origin());
			st.setString(2, f.getFlight_dest());
			st.setString(3, f.getFlight_num());
			st.setString(4, f.getFlight_date());
			
			if(!st.execute()) {
				if(st.getUpdateCount() > 0) {
					ret = 1;
					System.out.println("Flight Added");
					
					st = con.prepareStatement("SELECT seq_flight.CURRVAL FROM DUAL");
					ResultSet rsfid = st.executeQuery();
					rsfid.next();
					f.setFlight_id(rsfid.getInt(1));
					
					PreparedStatement st2 = con.prepareStatement(q2);
					st2.setString(1, f.getCurrency());
					st2.setString(2, f.getPrice());
					st2.setInt(3, f.getFlight_id());
					
					if(!st2.execute()) {
						if(st2.getUpdateCount() > 0) {
							ret = 2;
							System.out.println("Fare added");
						}
					}
					else {
						System.out.println("Fare not added");
					}
					
					st2.close();
				}
			}
			else {
				System.out.println("Flight not added");
			}
			
			st.close();
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public static List<Flight> getAllFlights() {
		List<Flight> fl_list = new ArrayList<Flight>();
		try {
			Connection con = FlightDAO.getConnection();
			String q = "SELECT F.*, currency, fare , TO_CHAR(TO_DATE(flight_date,'DD/MM/YYYY')) AS fdate FROM flight F INNER JOIN fare FR ON FR.flight_id = F.id WHERE flight_date >= CURRENT_DATE ORDER BY flight_date";
			ResultSet st = con.prepareStatement(q).executeQuery();
			
			while(st.next()) {
				Flight f = new Flight();
				f.setFlight_id(st.getInt(1));
				f.setCurrency(st.getString("currency"));
				f.setFlight_date(st.getString("fdate"));
				f.setFlight_dest(st.getString("dest"));
				f.setFlight_num(st.getString("flight_number"));
				f.setFlight_origin(st.getString("origin"));
				f.setPrice(st.getString("fare"));
				
				fl_list.add(f);
			}
			
			st.close();
			con.close();
		}
		catch (Exception e) {
			System.out.println("Error in fetching all flights");
			e.printStackTrace();
		}
		return fl_list;
	}
	
	public static List<Flight> searchFlight(Flight f) {
		List<Flight> fl_list = new ArrayList<Flight>();
		try {
			Connection con = FlightDAO.getConnection();
			PreparedStatement st = null;
			String q;
			
			if(f.getFlight_date() == null || f.getFlight_date().equals("")) {
				q = "SELECT F.*, currency, fare , TO_CHAR(TO_DATE(flight_date,'DD/MM/YYYY')) AS fdate FROM flight F INNER JOIN fare FR ON FR.flight_id = F.id WHERE origin=UPPER(?) AND dest=UPPER(?) AND  flight_date >= CURRENT_DATE ORDER BY flight_date";
				st = con.prepareStatement(q);				
			}
			else {
				q = "SELECT F.*, currency, fare , TO_CHAR(TO_DATE(flight_date,'DD/MM/YYYY')) AS fdate FROM flight F INNER JOIN fare FR ON FR.flight_id = F.id WHERE origin=UPPER(?) AND dest=UPPER(?) AND  flight_date = TO_DATE(?,'YYYY-MM-DD') ORDER BY flight_date";
				st = con.prepareStatement(q);
				st.setString(3, f.getFlight_date());
			}
						
			st.setString(1, f.getFlight_origin());
			st.setString(2, f.getFlight_dest());
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Flight rf = new Flight();
				rf.setFlight_id(rs.getInt(1));
				rf.setCurrency(rs.getString("currency"));
				rf.setFlight_date(rs.getString("fdate"));
				rf.setFlight_dest(rs.getString("dest"));
				rf.setFlight_num(rs.getString("flight_number"));
				rf.setFlight_origin(rs.getString("origin"));
				rf.setPrice(rs.getString("fare"));
				
				fl_list.add(rf);
			}
			
			rs.close();
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		
		return fl_list;
	}
	
}
