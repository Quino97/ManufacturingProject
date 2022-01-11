import java.sql.*;
public class AddMethod {

	public static boolean AddData(String velocity, String hydration, String diamond, String ra1, String ra2, String ra3,
			String ra4, String ref) {
		boolean st =false;

		Double vel = Double.parseDouble(velocity);
		Double hyd = Double.parseDouble(hydration);
		Double dia = Double.parseDouble(diamond);
		Double raa1 = Double.parseDouble(ra1);
		Double raa2 = Double.parseDouble(ra2);
		Double raa3 = Double.parseDouble(ra3);
		Double raa4 = Double.parseDouble(ra4);

		
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=admin&password=admin");
            PreparedStatement ps = con.prepareStatement("INSERT INTO experiment (ref,velocity,hydration,diamond,ra1,ra2,ra3,ra4)" 
            + "VALUES ("+ref+","+vel+","+hyd+","+dia+","+raa1+","+raa2+","+raa3+","+raa4+")");
            ps.executeUpdate();
            st = true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;

	}

}
