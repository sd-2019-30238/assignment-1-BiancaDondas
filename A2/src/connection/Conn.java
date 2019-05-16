package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	static Connection con= null;
	private Conn() {
		
	}
	public static Connection getConnection() {
		
		try {
			if(con==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql:/sd1?&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","paroladb");
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return con;
	}
	

}