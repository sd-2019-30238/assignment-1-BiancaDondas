package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

import connection.Conn;
import model.User;

public class UserDAO {

	private static Connection con = Conn.getConnection();

	public void insertUser(String name, String surname, String email, String parola, String title)
			throws SQLException, ClassNotFoundException {
		PreparedStatement pr = con.prepareStatement("insert into users values (?,?,?,?,?)");

		pr.setString(1, name);
		pr.setString(2, surname);
		pr.setString(3, parola);
		pr.setString(4, email);
		pr.setString(5, title);
		pr.executeUpdate();
		System.out.println("user inserted");
		pr.close();
	}

	public void addPayment(String email, String method) throws SQLException, ClassNotFoundException {
		PreparedStatement pr = con.prepareStatement("insert into payments values (?,?,?)");

		pr.setString(1, email);
		pr.setString(2, method);
		pr.setString(3, "Yes");
		pr.executeUpdate();
		pr.close();
	}
	public String getUserById(String mail) throws SQLException
	{
		String query = "Select * from users where email='"+mail+"'";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		result.next();
		return result.getString(1);
 
		
	}
	
	public static List<User> showAllUsers() throws ClassNotFoundException, SQLException {
		PreparedStatement pr = (PreparedStatement) con.prepareStatement("select * from users");
		ResultSet result = pr.executeQuery();

		ArrayList<User> allUsers = new ArrayList<>();
		while (result.next()) {
			System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " "
					+ result.getString(4));
		}

		return allUsers;
	}

	public int searchUser(String username, String password) throws SQLException, ClassNotFoundException {
		
		  PreparedStatement pr =con.prepareStatement("SELECT COUNT(email) AS num FROM users WHERE email="+"'"
		  +username+"'"+"AND"+" parola="+"'"+password+"'");
		  ResultSet rs = pr.executeQuery();
		  Statement statement =getCon().createStatement();
		  String pr1 ="SELECT title FROM users WHERE email="+"'"+username+"'";
		  ResultSet t = statement.executeQuery(pr1);
		  t.next();
		 // System.out.println(t.getString(1));
		  rs.next();
		  int usersNumber=rs.getInt("num");
		  if(usersNumber==1) { 
			 // System.out.println("User found!"); 
			  if(t.getString(1).equals("staff"))
			  { 
				  return 0;
				  }
			  else return 1;
			  }
		  else if(usersNumber==0) { System.out.println("User not found!"); }
		  
		  return 2;
		  
		  }

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		UserDAO.con = con;
	}

	

}