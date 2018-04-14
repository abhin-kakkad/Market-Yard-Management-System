public class Receipt {

	int transaction_id;
	int entity_id_1;
	int entity_id_2;
	int quantity;
	double price;
	double tax;
	double total;
	
	public Receipt(int transaction_id, int entity_id_1, int entity_id_2,
			int quantity, double price, double tax, double total) {
		super();
		this.transaction_id = transaction_id;
		this.entity_id_1 = entity_id_1;
		this.entity_id_2 = entity_id_2;
		this.quantity = quantity;
		this.price = price;
		this.tax = tax;
		this.total = total;
	}
	
	
}
