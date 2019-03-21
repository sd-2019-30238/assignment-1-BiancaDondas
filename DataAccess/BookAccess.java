package DataAccess;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
	public void filterByAuthor(String author) {
		try {
			String query="Select * from books where author = '"+author+"';";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
			}
					
		}catch(Exception e) {
			
			System.out.println("There are no books in by that author!");
		}	  
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
}
