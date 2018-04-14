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
		if(pwd.length()>=8 && pwd.length()<=20)
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
				System.out.println("Enter a valid password!(8-20 characters)");
				pwd=sc.nextLine();
			}
		}while(f2==0);
		this.setPassword(pwd);
		
		System.out.println("Enter Bank Details:");
		this.setBank_details(sc.nextLine());


		this.setId(id);
		sc.close();
		
		app.insertFarmer(this.getName(), this.getEmail_id(), this.getPhone_no(), this.getPassword(), this.getBank_details());
        
		return id;
	}
	
	public void update_profile()
	{
		//display previous details
		int choice;
		do
		{
			System.out.println("Enter the field you want to update from the following menu:");
			System.out.println("1. Name");
			System.out.println("2. Email-ID");
			System.out.println("3. Password");
			System.out.println("4. Phone no.");
			System.out.println("5. Bank Details");
			System.out.println("6. Submit");
			
			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1: System.out.println("Enter name:");
					this.setName(sc.nextLine());
					break;
			case 2:	System.out.println("Enter Email-ID:");
					this.setEmail_id(sc.nextLine());					
					break;
			case 3:	System.out.println("Password:");
			String pwd=sc.nextLine();
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
			case 4:	System.out.println("Enter Phone no.:");
					String phoneNo=sc.nextLine();
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
					break;
			case 5:	System.out.println("Enter Bank Details");
			this.setBank_details(sc.nextLine());					
			break;
			}
			
			sc.close();
		}while(choice!=13);	
		//display new details
	}
	
}
