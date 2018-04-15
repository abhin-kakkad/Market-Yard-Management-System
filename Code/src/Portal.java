import java.util.*;

public class Portal {

		private static String M_Id="999";
		private static String M_type="Mandi-Admin";
		private static String M_pwd="sabkamaalik";
	
		private static String id;
		private static String id1;
		private static int flag=0;
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
			if(type.equals(M_type)) {
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter ID");
				String usr=sc.nextLine();
				System.out.println("Enter Password");
				String pwd=sc.nextLine();
				
				if(usr.equals(M_Id) && pwd.equals(M_pwd))
					System.out.println("You have universal access to the Mandi");
				else
					System.out.println("Please check your credentials");
			}
			else {
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the Phone No.");
				String usr=sc.nextLine();
				
				DemoDB d = new DemoDB();
				String pwd=d.getPassword(usr,type);
				id1=d.getID(usr,type);
				//System.out.println(id);
				
				System.out.println("Enter the password");
				String p=sc.nextLine();
				
				if(p.equals(pwd))
				{
					System.out.println("Mandi ma aapnu swagat che!!");
					flag=0;
				}
				else
				{
					System.out.println("The username or Password is invalid!");
					flag=1;
				}
			}
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
		
		System.out.println("Enter type: (Farmer/Wholesaler/Retailer/Customer/Mandi-Admin)");
		String type1=sc.nextLine();
		String type = type1.toLowerCase();
		flag=1;
		
      while(flag==1)
      {
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
		sc.nextLine();
		
		if(flag!=1)
		{
			if(type.equals("customer"))
			{
				Customer c = new Customer();
				c.listofactions(id1);
			}
			
			if(type.equals("farmer"))
			{
				Farmer f = new Farmer();
				f.listofactions(id1);
			}
			
			if(type.equals("wholesaler"))
			{
				Wholesaler w = new Wholesaler();
				w.listofactions(id1);
			}
			
			if(type.equals("retailer"))
			{
				Retailer r = new Retailer();
				r.listofactions(id1);
			}
		}
      }
	 sc.close();

  }
}