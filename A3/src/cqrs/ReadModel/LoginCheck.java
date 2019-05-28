package cqrs.ReadModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.Conn;

public class LoginCheck {

	private static Connection con = Conn.getConnection();
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		LoginCheck.con = con;
	}


	public String searchUser(String username, String password) throws SQLException, ClassNotFoundException {
		
		  String role = null;
		  PreparedStatement pr =con.prepareStatement("SELECT COUNT(email) AS num FROM users WHERE email="+"'"
		  +username+"'"+"AND"+" parola="+"'"+password+"'");
		  ResultSet rs = pr.executeQuery();
		  Statement statement =getCon().createStatement();
		  String pr1 ="SELECT title FROM users WHERE email="+"'"+username+"'";
		  ResultSet t = statement.executeQuery(pr1);
		  t.next();
		  rs.next();
		  int usersNumber=rs.getInt("num");
		  if(usersNumber==1) { 
			  if(t.getString(1).equals("staff"))
			  { 
				  role = "staff";
				  }
			  else role = "user";
			  }
		  else if(usersNumber==0) { System.out.println("User not found!"); }
		  
		  return role;
		  
		  }
	

	
}
