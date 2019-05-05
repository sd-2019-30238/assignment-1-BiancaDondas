package bussinessLogic;
import java.sql.SQLException;
import java.util.ArrayList;

import dataAccess.*;

public class BookLogic {

	BookAccess b = new BookAccess();
	public ArrayList<String> filterAuthor(String author)
	{
		
		try {
			ArrayList<String> result=b.filterByAuthor(author);
			return result;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 	
	}
	public ArrayList<String> filterGenre(String genre)
	{
		
		try {
			ArrayList<String> result=b.filterByGenre(genre);
			return result;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 	
	}
	public ArrayList<String> filterTitle(String title)
	{
		
		try {
			ArrayList<String> result=b.filterByTitle(title);
			return result;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 	
	}
	public String show(String user)
	{
		String result1=b.showBooks1(user);
		return result1;
	}
	public String available(String username,String title) throws SQLException
	{
		boolean ok = b.availabilty(title);
		if(ok==true) 
		{
			b.addBook(username, title);
		}
		else {
			b.addToWaitingList(username, title);
		}
		return null;
	}
	
	public boolean payment(String email) throws SQLException
	{
		if(b.verifyPayment(email).equals("Yes"))
		{
			return true;
		}
		else return false;
	}
	public void requestReturn(String email, String title)
	{
		b.addReturn(email, title);
	}
	public ArrayList<String> books()
	{
		try {
			ArrayList<String> result=b.showBooks();
			return result;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 	
	}
	
}
