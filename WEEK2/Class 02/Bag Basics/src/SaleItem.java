
public class SaleItem {
	
	private int price; 
	private String description; 
	
	//constructor 
	public SaleItem(){
		
	}
	
	public SaleItem(String description, int price){
		this.price = price;
		this.description = description; 
	}
	
	public String getDescription() {
		return description;
	} // end getDescription

	public int getPrice() {
		return price;
	} // end getPrice

	public String toString() {
		return description + "\t$" + price / 100 + "." + price % 100;
	} // end toString
}
