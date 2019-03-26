package DataAccess;
import java.awt.List;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class BookAccess {

	private static Connection con = Conn.getConnection();
	
	public void showBooks() {
		try {
			String query="Select * from books";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
			}
					
		}catch(Exception e) {
			
			System.out.println("Conection failed!");
		}	  
	}
	public void filterByTitle(String title) {
		try {
			String query="Select * from books where title = '"+title+"';";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
			}
					
		}catch(Exception e) {
			
			System.out.println("There are no books with that title!");
		}	  
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
	
	public void filterByGenre(String genre) {
		try {
			String query="Select * from books where genre = '"+genre+"';";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
			}
					
		}catch(Exception e) {
			
			System.out.println("There are no books in that genre!");
		}	  
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
}
