import java.util.*;

public class Portal {

		private static String id;
		private static String type;	//current user id and type
		
		public static String getId() {
			return id;
		}
		public static void setId(String id) {
			Portal.id = id;
		}
		public static String getType() {
			return type;
		}
		public static void setType(String type) {
			Portal.type = type;
		}
		
		public static void authenticate(String type)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Phone No.");
			String usr=sc.nextLine();
			
			DemoDB d = new DemoDB();
			String pwd=d.getPassword(usr,type);
			//System.out.println(pwd);
			
			System.out.println("Enter the password");
			String p=sc.nextLine();
			
			if(p.equals(pwd))
				System.out.println("Mandi ma aapnu swagat che!!");
			else
				System.out.println("The username or Password is invalid!");
			//call authenticate
			sc.close();
		}
		
		public static void signUp(String type)
		{
			if (type.equals("farmer"))
			{
				Farmer f = new Farmer();
				Portal.id=f.registration_form();
				Portal.type=type;
			}
			
			else if (type.equals("wholesaler"))
			{
				Wholesaler w = new Wholesaler();
				Portal.id=w.registration_form();
				Portal.type=type;
			}
			
			else if (type.equals("retailer"))
			{
				Retailer r = new Retailer();
				Portal.id=r.registration_form();
				Portal.type=type;
			}
			
			else if (type.equals("customer"))
			{
				Customer c = new Customer();
				Portal.id=c.registration_form();
				Portal.type=type;
			}
			else
			{
				System.out.println("Enter proper type");
			}
				
		}
		
	public static void main(String args[]) {
		Portal.setId("null");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter type: (Farmer/Wholesaler/Retailer/Customer)");
		String type=sc.nextLine();

		System.out.println("Enter your choice:");
		System.out.println("1. Signup");
		System.out.println("2. Login");
		int choice=sc.nextInt();
		
		switch(choice)
		{
		case 1: Portal.signUp(type);
				break;
		case 2: Portal.authenticate(type);
				break;
				
		}
		if(type == "Customer")
		{
			System.out.println("What do you want to buy?");
			String good=sc.nextLine();
			double price=Portal.price_details(good); 
			System.out.println("Do you want to by at this price?");
			char choice = sc.nextch

		}
			
		sc.close();
		
	}
}
