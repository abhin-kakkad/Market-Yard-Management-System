import java.util.*;
import java.io.*;

public class Customer
{
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

	public void setBank_details(String details) {
		this.bank_details = details;
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
		
		app.insertCustomer(this.getName(), this.getEmail_id(), this.getPhone_no(), this.getPassword(), this.getBank_details());
        
		return id;
	}




	Scanner keyboard = new Scanner(System.in);

	public double bargain(double trader_price)
    {
    	System.out.println("Do you want to bargain?[Y/N]");
    	char c=keyboard.next().charAt(0);
    	if(c=='N')
    	{
    		System.out.println("Confirmed final price="+trader_price);
    		return trader_price;
    	}
    	else
    	{
    		System.out.println("Enter Customer's price:");
    		double customer_price = keyboard.nextDouble();
    		return customer_price;
    	}
    }
	
}
