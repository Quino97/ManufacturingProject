import java.sql.*;
public class ConnectDB {
	
	public static void main(String[] args) {

    }

	public static boolean checkUser(String username, String password) {
		boolean st =false;
		System.out.println(username);
		System.out.println(password);
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=admin&password=admin");
            PreparedStatement ps = con.prepareStatement("select * from login where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;
	}
}

