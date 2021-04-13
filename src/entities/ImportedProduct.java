package entities;

public class ImportedProduct extends Product {
	
	private double customsFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, double price, double custonsFee) {
		super(name, price);
		this.customsFee = custonsFee;
	}

	public double getCustonsFee() {
		return customsFee;
	}

	public void setCustonsFee(double custonsFee) {
		this.customsFee = custonsFee;
	}
	
	public double totalPrice() {
		return price += customsFee;
	}
	
	@Override
	public String priceTag() {
		return name + " $ " + totalPrice() + " (Customs fee: $ " + customsFee + ")";
	}
}
