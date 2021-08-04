package beans;



public class FoodPrice {
	private String food;
	
	public void setFood(String f) {
		food = f;
	}
	
	public String getFood() {
		return food;
	}
	
	public String getPrice() {
		if(food.equals("hb")) {
			return "200";
		}
		else if(food.equals("sp")) {
			return "160";
		}
		else if(food.equals("cs")) {
			return "180";
		}
		else if(food.equals("ws")) {
			return "210";
		}
		
		else {
			return "-Invalid Item. Select an Item from the drop down menu-";
		}
	}
}
