package product;

public class DiscountedProduct extends Product {
	private double discountRate;
	
	public DiscountedProduct(int id, String name, int price, int stock, double discountRate) {
		super(id, name, price, stock);
		this.discountRate =discountRate;
	}
	public double calculateDiscountedPrice() {
		return (int) (getPrice() * (1 - discountRate));
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	public String toString() {
		return super.toString() +
				String.format(",割引率=%.1f, 割引後価格=%.0f", discountRate, calculateDiscountedPrice());
		
	}

}
