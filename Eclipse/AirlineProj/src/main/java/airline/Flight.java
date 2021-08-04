package airline;
//id num pk
//origin
//dest
//flight_number varchar2(10)
//flight_date

//id number primary key
//currency
//fare 
//flight_id FK on flight.id

public class Flight {
	private int flight_id;
	private String flight_origin, flight_dest, flight_num, flight_date, price, currency;
	
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public String getFlight_origin() {
		return flight_origin;
	}
	public void setFlight_origin(String flight_origin) {
		this.flight_origin = flight_origin;
	}
	public String getFlight_dest() {
		return flight_dest;
	}
	public void setFlight_dest(String flight_dest) {
		this.flight_dest = flight_dest;
	}
	public String getFlight_num() {
		return flight_num;
	}
	public void setFlight_num(String flight_num) {
		this.flight_num = flight_num;
	}
	public String getFlight_date() {
		return flight_date;
	}
	public void setFlight_date(String flight_date) {
		this.flight_date = flight_date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
