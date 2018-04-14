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
	      else
				return null;
				
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	public static void main(String args[]) {
		/**/
		
		
		
	}
}
