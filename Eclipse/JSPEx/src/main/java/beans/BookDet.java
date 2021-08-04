package beans;

public class BookDet {
	private float price = 0;
	private String pubs;
	
	public void setPub(String p) {
		pubs = p;
		if(p.equals("pub1")) {
			price = 500;
		}
		else if(p.equals("pub2")) {
			price = 800;
		}
		else if(p.equals("pub3")) {
			price = 1000;
		}
		else {
			price = -1;
		}
	}
	
	public String getPub() {
		return pubs;
	}
	
	public String getPrice() {
		if (price == -1) {
			return "Not Found";
		}
		else {
			return "" + price;
		}
	}
	
}
