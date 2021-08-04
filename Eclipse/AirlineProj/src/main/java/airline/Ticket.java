package airline;
//-booking id pk (ticket_id)
//-booking_date
//-flight_id FK on flight.id
//-status
//
//-id pk
//-fname
//-lname
//-gender
//-booking_id FK on booking_record.id


public class Ticket extends Flight {
	private int ticket_id, passenger_id;
	private String ticket_status, passenger_fname, passenger_lname, passenger_gender;
	
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getTicket_status() {
		return ticket_status;
	}
	public void setTicket_status(String ticket_status) {
		this.ticket_status = ticket_status;
	}
	public String getPassenger_fname() {
		return passenger_fname;
	}
	public void setPassenger_fname(String passenger_fname) {
		this.passenger_fname = passenger_fname;
	}
	public String getPassenger_lname() {
		return passenger_lname;
	}
	public void setPassenger_lname(String passenger_lname) {
		this.passenger_lname = passenger_lname;
	}
	public String getPassenger_gender() {
		return passenger_gender;
	}
	public void setPassenger_gender(String passenger_gender) {
		this.passenger_gender = passenger_gender;
	}
}
