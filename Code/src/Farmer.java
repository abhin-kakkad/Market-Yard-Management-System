import java.util.*;

public class Farmer {
	String id;
	String name;
	String email_id;
	String password;
	String phone_no;
	String bank_details;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getBank_details() {
		return bank_details;
	}

	public void setBank_details(String bank_details) {
		this.bank_details = bank_details;
	}
	
	public boolean checkPhoneNo(String phoneNo)
	{
		if(phoneNo.length()==10)
			return true;
		else
			return false;
	}

	public boolean checkPassword(String pwd)
	{
		if(pwd.length()>=6 && pwd.length()<=15)
			return true;
		else
			return false;
	}
	
	public String registration_form()
	{
		DemoDB app = new DemoDB();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Registration Form");
		
		System.out.println("Enter name:");
		this.setName(sc.nextLine());
		
		System.out.println("Enter Email-ID:");
		this.setEmail_id(sc.nextLine());
		
		System.out.println("Enter Mobile no.:");
		String phoneNo=sc.nextLine();
		int flag1=0;
		do
		{
			if(checkPhoneNo(phoneNo))
				flag1=1;
			else
			{
				System.out.println("Enter a valid mobile no!(Should have 10 digits)");
				phoneNo=sc.nextLine();
			}
		}while(flag1==0);
		this.setPhone_no(phoneNo);
		
		System.out.println("Enter password:");
		String pwd=sc.nextLine();
		int f2=0;
		do
		{
			if(checkPassword(pwd))
				f2=1;
			else
			{
				System.out.println("Enter a valid password!(6-15 characters)");
				pwd=sc.nextLine();
			}
		}while(f2==0);
		this.setPassword(pwd);
		
		System.out.println("Enter Bank Details:");
		this.setBank_details(sc.nextLine());


		this.setId(id);
		
		app.insertFarmer(this.getName(), this.getEmail_id(), this.getPhone_no(), this.getPassword(), this.getBank_details());
        
		return id;
	}
	DemoDB d =new DemoDB();
	public void update_profile(String id1)
	{
		//display previous details
		int choice;
		System.out.println("Enter the field you want to update from the following menu:");
		System.out.println("1. Name");
		System.out.println("2. Email-ID");
		System.out.println("3. Password");
		System.out.println("4. Phone no.");
		System.out.println("5. Bank Details");
		DemoDB d1=new DemoDB();
		
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			sc.nextLine();
			int id=Integer.parseInt(id1);
			String uname=d1.getName(id,"farmer");
			String uemailid=d1.getemailid(id,"farmer");
			
			String phoneNo=d1.getphoneno(id,"farmer");
			String pwd=d1.getPassword(phoneNo,"farmer");
			String bd=d1.getbank(id,"farmer");
			int status=0;
			if(choice>6)
			   {
				   status=1;
					System.out.println("INVALID CHOICE ENTER CHOICE AGAIN!");
			   }
			switch(choice)
			{
			case 1: System.out.println("Enter name:");
					uname=sc.nextLine();
					this.setName(uname);
					System.out.println("Name updated successfully");
					break;
			case 2:	System.out.println("Enter Email-ID:");
					uemailid=sc.nextLine();
					this.setEmail_id(uemailid);
					System.out.println("Email-ID updated successfully");
					break;
			case 3:	System.out.println("Password:");
					pwd=sc.nextLine();
					int flag2=0;
					do
					{
						if(checkPassword(pwd))
							flag2=1;
						else
						{
							System.out.println("Enter a valid password!!(6-15 chars, atleast 1 Numeric,atleast 1 alphabet)");
							pwd=sc.nextLine();
						}
					}while(flag2==0);
					this.setPassword(pwd);
					System.out.println("Password updated successfully");
					break;
					
			case 4:	System.out.println("Enter Phone no.:");
					phoneNo=sc.nextLine();
					int flag1=0;
					do
					{
						if(checkPhoneNo(phoneNo))
							flag1=1;
						else
						{
							System.out.println("Enter a valid mobile no.!!(Should have 10 digits)");
							phoneNo=sc.nextLine();
						}
					}while(flag1==0);
					this.setPhone_no(phoneNo);
					System.out.println("Phone Number updated successfully");
					break;
					
			case 5:	System.out.println("Enter Bank Details");
			        bd = sc.nextLine();
					this.setBank_details(bd);
					System.out.println("Bank details updated successfully");
					break;
			}
		   
			if(status == 0)
			{
				System.out.println("Do you want to update anything else?[YES/NO]");
					String r1 = sc.nextLine();
					String r=r1.toLowerCase();
					if(r.equals("yes"))
					{	
						d.updatefarmer(id,uname,uemailid,pwd,phoneNo,bd);
						System.out.println("Enter the field you want to update from the following menu:");
						System.out.println("1. Name");
						System.out.println("2. Email-ID");
						System.out.println("3. Password");
						System.out.println("4. Phone no.");
						System.out.println("5. Bank Details");
						System.out.println("6. Submit");
					}
					else
					{
						d.updatefarmer(id,uname,uemailid,pwd,phoneNo,bd);
						System.out.println("Your profile has been updated");
						break;
					}	
			}
			
			//sc.close();
		}
		//display new details
	}
	
	Scanner keyboard = new Scanner(System.in);
	
	public void addStock(String id)
	{
		Receipt rec = new Receipt();
		System.out.println("Enter the Commodity name you want to add in Mandi:");
		String s1=keyboard.nextLine();
		String s2=d.price_details(s1);
		
		
		System.out.println("Enter the quantity:");
		String quantity1 = keyboard.nextLine();
		double quantity = Double.parseDouble(quantity1);
		
		if(s2 == null)
		{
			
			System.out.println("Enter the price at which you want to sell/add goods to Mandi:");
			String price1 = keyboard.nextLine();
			double price = Double.parseDouble(price1);
			s2=price1;
			d.insertGoods(s1,quantity1,price1);
		}
		else
		{
			String tot_quant=d.quantity_details(s1);
			double init=Double.parseDouble(tot_quant)+quantity;
			String s=String.valueOf(init);
			d.updategoods(s1,s);
		}
		System.out.println("Goods Added Successfully to the Mandi!!");
		rec.generatebill("farmer",id,s2,quantity1);
	}

	public void listofactions(String id)
	{
		int flag=1;
		
		while(flag==1)
		{
			System.out.println("Available actions for farmer are given below:\n1.Update Profile\n2.Add Goods\n");
	    	System.out.println("Enter your choice:");
	    	int x=keyboard.nextInt();
	    	keyboard.nextLine();
	    	switch(x)
	    	{
	    	case 1:
	    		update_profile(id);
	    		break;
	    	case 2:
	    		addStock(id);
	    		break;
	    	}
	    	
	    	System.out.println("Do you want to logout?[yes/no]");
	    	String res1=keyboard.nextLine();
	    	String res=res1.toLowerCase();
	    	if(res.equals("yes"))
	    	{
	    		System.out.println("You are successfully Logout from the System!!");
	    		flag=0;
	    	}
		}
	}
}
