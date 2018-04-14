public class Account {

	int id;
	int date;
	int transaction_id;
	double amount_received;
	double amount_to_be_paid;
	double balance;
	String type;
	
	public Account(int id, int date, int transaction_id, double amount_received,
			double amount_to_be_paid, double balance, String type) {
		super();
		this.id = id;
		this.date = date;
		this.transaction_id = transaction_id;
		this.amount_received = amount_received;
		this.amount_to_be_paid = amount_to_be_paid;
		this.balance = balance;
		this.type = type;
	}
	
	
}
