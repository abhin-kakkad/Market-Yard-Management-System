import java.sql.*;

public class DemoDB {
	
	private Connection connect() {

        String url = "jdbc:postgresql://localhost:5433/market" ;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, "postgres", "user");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	/*--------------------------------InsertQueries-----------------------------------------------*/
	
	public void insertFarmer(String name, String email_id, String phone_no, String pwd, String bank_details) {
		String sql="INSERT INTO yard.farmer(name, email_id, password, phone_no, bank_details) VALUES(?,?,?,?,?)";
		
		try(Connection conn=this.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, email_id);
	            pstmt.setString(4, phone_no);
	            pstmt.setString(3, pwd);
	            pstmt.setString(5, bank_details);
	            
	            pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertCustomer(String name, String email_id, String phone_no, String pwd, String bank_details) {
		String sql="INSERT INTO yard.customer(name, email_id, password, phone_no, bank_details) VALUES(?,?,?,?,?)";
		
		try(Connection conn=this.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, email_id);
	            pstmt.setString(4, phone_no);
	            pstmt.setString(3, pwd);
	            pstmt.setString(5, bank_details);
	            
	            pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertRetailer( String name, String email_id, String phone_no, String pwd, String bank_details) {
		String sql="INSERT INTO yard.retailer(name, email_id, password, phone_no, bank_details) VALUES(?,?,?,?,?)";
		
		try(Connection conn=this.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, email_id);
	            pstmt.setString(4, phone_no);
	            pstmt.setString(3, pwd);
	            pstmt.setString(5, bank_details);
	            
	            pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertWholesaler(String name, String email_id, String phone_no, String pwd, String bank_details) {
		String sql="INSERT INTO yard.wholesaler(name, email_id, password, phone_no, bank_details) VALUES(?,?,?,?,?)";
		
		try(Connection conn=this.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, email_id);
	            pstmt.setString(4, phone_no);
	            pstmt.setString(3, pwd);
	            pstmt.setString(5, bank_details);
	            
	            pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void insertGoods(String name, String quantity, String price)
	{
		String sql="INSERT INTO yard.goods(name, quantity, price) VALUES(?,?,?)";
		
		try(Connection conn=this.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, quantity);
	            pstmt.setString(3, price);
	            
	            pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertReceipt(String id, String type, String ops, String amt)
	{
		String sql="INSERT INTO yard.Receipt(user_id, type, operation,amount) VALUES(?,?,?,?)";
		
		try(Connection conn=this.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, id);
	            pstmt.setString(2, type);
	            pstmt.setString(3, ops);
	            pstmt.setString(4, amt);
	            
	            pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*------------------------------FetchQueries------------------------------------*/
	
	public String getPassword(String usr, String type) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5433/market", "postgres", "user");
			
			if(type.equals("wholesaler"))
			{
				String sql ="select password from yard.wholesaler where phone_no = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("farmer"))
			{
				String sql ="select password from yard.farmer where phone_no = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("customer"))
			{
				String sql ="select password from yard.customer where phone_no = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("retailer"))
			{
				String sql ="select password from yard.retailer where phone_no = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			
	      else
				return null;
				
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	public String getID(String usr, String type) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5433/market", "postgres", "user");
			
			if(type.equals("wholesaler"))
			{
				String sql ="select id from yard.wholesaler where phone_no = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("farmer"))
			{
				String sql ="select id from yard.farmer where phone_no = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("customer"))
			{
				String sql ="select id from yard.customer where phone_no = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("retailer"))
			{
				String sql ="select id from yard.retailer where phone_no = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			
	      else
				return null;
				
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	public String getName(int usr,String type) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5433/market", "postgres", "user");
			
			if(type.equals("wholesaler"))
			{
				String sql ="select name from yard.wholesaler where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("farmer"))
			{
				String sql ="select name from yard.farmer where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("customer"))
			{
				String sql ="select name from yard.customer where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("retailer"))
			{
				String sql ="select name from yard.retailer where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			
	      else
				return null;
				
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	public String getemailid(int usr,String type) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5433/market", "postgres", "user");
			
			if(type.equals("wholesaler"))
			{
				String sql ="select email_id from yard.wholesaler where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("farmer"))
			{
				String sql ="select email_id from yard.farmer where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("customer"))
			{
				String sql ="select email_id from yard.customer where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("retailer"))
			{
				String sql ="select email_id from yard.retailer where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			
	      else
				return null;
				
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	public String getphoneno(int usr,String type) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5433/market", "postgres", "user");
			
			if(type.equals("wholesaler"))
			{
				String sql ="select phone_no from yard.wholesaler where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("farmer"))
			{
				String sql ="select phone_no from yard.farmer where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("customer"))
			{
				String sql ="select phone_no from yard.customer where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("retailer"))
			{
				String sql ="select phone_no from yard.retailer where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			
	      else
				return null;
				
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	public String getbank(int usr,String type) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5433/market", "postgres", "user");
			
			if(type.equals("wholesaler"))
			{
				String sql ="select bank_details from yard.wholesaler where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("farmer"))
			{
				String sql ="select bank_details from yard.farmer where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("customer"))
			{
				String sql ="select bank_details from yard.customer where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			else if(type.equals("retailer"))
			{
				String sql ="select bank_details from yard.retailer where id = ? ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,usr);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
			
			
	      else
				return null;
				
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	public String price_details(String good)
	{
		String sql ="select price from yard.goods where name = ? ";
	
		try(Connection conn=this.connect(); 
				PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1,good);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					return rs.getString(1);
				}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public String quantity_details(String good)
	{
		String sql ="select quantity from yard.goods where name = ? ";
	
		try(Connection conn=this.connect(); 
				PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1,good);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					return rs.getString(1);
				}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	/*---------------------------------UpdateQueries---------------------------------*/
	
	public void updatefarmer(int id,String name, String email_id, String pwd, String phoneNo, String bank_details)
	{
		String sql="UPDATE yard.farmer SET name= ? ,"+ "email_id= ? ,"+ "password= ? ,"+ "phone_no= ? ,"+ "bank_details= ? "+"where id= ? ";
		
		try(Connection conn=this.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, email_id);
	            pstmt.setString(4, phoneNo);
	            pstmt.setString(3, pwd);
	            pstmt.setString(5, bank_details);
	            pstmt.setInt(6, id);
	            
	            pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updatecustomer(int id,String name, String email_id, String pwd, String phoneNo, String bank_details)
	{
		String sql="UPDATE yard.customer SET name= ? ,"+ "email_id= ? ,"+ "password= ? ,"+ "phone_no= ? ,"+ "bank_details= ? "+"where id= ? ";
		
		try(Connection conn=this.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, email_id);
	            pstmt.setString(4, phoneNo);
	            pstmt.setString(3, pwd);
	            pstmt.setString(5, bank_details);
	            pstmt.setInt(6, id);
	            
	            pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updatewholesaler(int id,String name, String email_id, String pwd, String phoneNo, String bank_details)
	{
		String sql="UPDATE yard.wholesaler SET name= ? ,"+ "email_id= ? ,"+ "password= ? ,"+ "phone_no= ? ,"+ "bank_details= ? "+"where id= ? ";
		
		try(Connection conn=this.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, email_id);
	            pstmt.setString(4, phoneNo);
	            pstmt.setString(3, pwd);
	            pstmt.setString(5, bank_details);
	            pstmt.setInt(6, id);
	            
	            pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateretailer(int id,String name, String email_id, String pwd, String phoneNo, String bank_details)
	{
		String sql="UPDATE yard.retailer SET name= ? ,"+ "email_id= ? ,"+ "password= ? ,"+ "phone_no= ? ,"+ "bank_details= ? "+"where id= ? ";
		
		try(Connection conn=this.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, email_id);
	            pstmt.setString(4, phoneNo);
	            pstmt.setString(3, pwd);
	            pstmt.setString(5, bank_details);
	            pstmt.setInt(6, id);
	            
	            pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updategoods(String name1,String quant)
	{
		String sql="UPDATE yard.goods SET quantity= ?" + "where name = ?";
		
		try(Connection conn=this.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, quant);
	            pstmt.setString(2, name1);
	            
	            pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void main(String args[]) {
		/**/
		
		
		
	}
}
