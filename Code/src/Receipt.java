public class Receipt {

	int transaction_id;
	int entity_id_1;
	int entity_id_2;
	int quantity;
	double price;
	double tax;
	double total;
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getEntity_id_1() {
		return entity_id_1;
	}
	public void setEntity_id_1(int entity_id_1) {
		this.entity_id_1 = entity_id_1;
	}
	public int getEntity_id_2() {
		return entity_id_2;
	}
	public void setEntity_id_2(int entity_id_2) {
		this.entity_id_2 = entity_id_2;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	DemoDB d = new DemoDB();

	
	public void generatebill(String type,String id,String price,String quant)
	{
		if(type.equals("farmer"))
		{
			double p=Double.parseDouble(price);
			double q=Double.parseDouble(quant);
			double total_amount = p*q;
			System.out.println("\tThe total amount you will get is:"+total_amount);
			System.out.println("\t\t\t\t5 % GST:"+ 0.05*total_amount);
			double amount_received=total_amount-0.05*total_amount;
			System.out.println("\tFinal Amount you will get is:"+amount_received);
			
			String amt = String.valueOf(amount_received);
			
			d.insertReceipt(id, type, "Add Goods", amt);
		}
		
		if(type.equals("wholesaler"))
		{
			double p=Double.parseDouble(price);
			double q=Double.parseDouble(quant);
			double total_amount = p*q;
			System.out.println("\tThe total amount you will get is:"+total_amount);
			System.out.println("\t\t\t\t5 % GST:"+ 0.05*total_amount);
			double amount_received=total_amount+0.05*total_amount;
			System.out.println("\tFinal Amount you will get is:"+amount_received);
			
			String amt = String.valueOf(amount_received);
			
			d.insertReceipt(id, type, "Bought from Farmer", amt);
		}
		
		if(type.equals("retailer"))
		{
			//System.out.println(type);
			double p=Double.parseDouble(price);
			double q=Double.parseDouble(quant);
			double total_amount = p*q;
			System.out.println("\tThe total amount you will get is:"+total_amount);
			System.out.println("\t\t\t\t5 % GST:"+ 0.05*total_amount);
			double amount_received=total_amount+0.05*total_amount;
			System.out.println("\tFinal Amount you will get is:"+amount_received);
			
			String amt = String.valueOf(amount_received);
			
			d.insertReceipt(id, type, "Bought from Farmer", amt);
		}
		
		if(type.equals("customer"))
		{
			double p=Double.parseDouble(price);
			double q=Double.parseDouble(quant);
			double total_amount = p*q;
			System.out.println("\tThe total amount you will get is:"+total_amount);
			System.out.println("\t\t\t\t5 % GST:"+ 0.05*total_amount);
			double amount_received=total_amount+0.05*total_amount;
			System.out.println("\tFinal Amount you will get is:"+amount_received);
			
			String amt = String.valueOf(amount_received);
			
			d.insertReceipt(id, type, "Bought from Trader", amt);
		}
		
	}
	
	
}
