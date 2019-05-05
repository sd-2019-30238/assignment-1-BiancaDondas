package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conn;
import model.User;

public class UserDAO {

	private static Connection con = Conn.getConnection();
	public void insertUser(String name, String surname, String email, String parola, String title) throws SQLException, ClassNotFoundException {
	    PreparedStatement pr =  con.prepareStatement("insert into users values (?,?,?,?,?)");

		pr.setString(1,name);
		pr.setString(2,surname );
		pr.setString(3,parola );
		pr.setString(4, email);
		pr.setString(5, title);
		pr.executeUpdate();
		System.out.println("user inserted");
		pr.close();
	 }
	public static List<User> showAllUsers() throws ClassNotFoundException, SQLException{
		PreparedStatement pr =  (PreparedStatement) con.prepareStatement("select * from users");
		ResultSet result = pr.executeQuery();

		ArrayList<User> allUsers = new ArrayList<>();
		while(result.next()) {
				System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " "
						+ result.getString(4));
		}

		return allUsers;
	}
	
	public boolean searchUser(String username, String password) throws SQLException, ClassNotFoundException {
		
			   PreparedStatement pr =  con.prepareStatement("SELECT COUNT(email) AS num FROM users WHERE email="+"'"+username+"'"+"AND"+" parola="+"'"+password+"'");
				ResultSet rs = pr.executeQuery();
		
				rs.next();
				int usersNumber=rs.getInt("num");
				System.out.println(username);
				if(usersNumber==1) {
					System.out.println("User found!");
					return true;
				}else if(usersNumber==0) {
					System.out.println("User not found!");
				}
		
				return false;
		
			}
}