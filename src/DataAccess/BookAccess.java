package DataAccess;
import java.awt.List;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
public class BookAccess {

	private static Connection con = Conn.getConnection();
	
	public void showBooks() {
		try {
			String query="Select * from books";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
				//return result.getString(2)+"\n";
			}		
		}catch(Exception e) {
			
			System.out.println("Conection failed!");
		}	  
	}
	public String showBooks1(String username) {
		try {
			String query="Select * from books where title = '"+username+"';";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				//System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
				return result.getString(2)+"\n";
			}		
		}catch(Exception e) {
			
			System.out.println("Conection failed!");
		}
		return username;	  
	}
	public void addBook(String username, String title) throws SQLException
	{
		java.sql.PreparedStatement statement=null;
		String query="Insert into reading (username, title) values (?,?)";
			statement=con.prepareStatement(query);
			statement.setString(1,username);
			statement.setString(2,title);
			statement.executeUpdate();
			//ArrayList<String> titles=new ArrayList<String>();
			// titles.add(arg0)
	}
	public ArrayList<String> filterByTitle(String title) throws SQLException {
		String query = "Select * from books where title='" + title+ "'";
		Statement statement=con.createStatement();
		ResultSet result=statement.executeQuery(query);
		ArrayList<String> titles=new ArrayList<String>();
		//ArrayList<String[]> authors=new ArrayList<String[]>();
		Book b = new Book();
		while(result.next()) {
				String unu = result.getString(2)+" "+result.getString(3);
				titles.add(unu);
		}
		
		return titles;  
	}

	public ArrayList<String> filterByAuthor(String author) throws SQLException
	{
		String query = "Select * from books where author='" + author+ "'";
		Statement statement=con.createStatement();
		ResultSet result=statement.executeQuery(query);
		ArrayList<String> authors=new ArrayList<String>();
		//ArrayList<String[]> authors=new ArrayList<String[]>();
		Book b = new Book();
		while(result.next()) {
				String unu = result.getString(2)+" "+result.getString(3);
				authors.add(unu);
		}
		
		return authors;
	}
	
	public ArrayList<String> filterByGenre(String genre) throws SQLException {
		String query = "Select * from books where genre='" + genre+ "'";
		Statement statement=con.createStatement();
		ResultSet result=statement.executeQuery(query);
		ArrayList<String> genre1=new ArrayList<String>();
		//ArrayList<String[]> authors=new ArrayList<String[]>();
		Book b = new Book();
		while(result.next()) {
				String unu = result.getString(2)+" "+result.getString(3);
				genre1.add(unu);
		}
		
		return genre1;
	}
	
	public boolean availabilty(String title)
	{
		try {
			String query="Select * from books where title ='"+title+"'";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			result.next();
			int numberOfBooks = result.getInt(7);
			if(numberOfBooks>0) return true;
		}catch(Exception e) {
			
			e.printStackTrace();
		}	  
		return false;
	}
	public void addToWaitingList(String email, String title)
	{
		try {
			java.sql.CallableStatement myStmt=userAccess.getCon().prepareCall("{call add_waiting(?,?)}");
			
			myStmt.setString(1,email);
			myStmt.setString(2,title);
			myStmt.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public String verifyPayment(String email) throws SQLException
	{
		
		String query="Select payed from payments where email = '"+email+"';";
		Statement statement1=con.createStatement();
		ResultSet result=statement1.executeQuery(query);
		result.next();
		String payed = result.getString(1);
		return payed;
		
	}
	
}
