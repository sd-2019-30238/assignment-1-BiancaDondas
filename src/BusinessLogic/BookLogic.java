package BusinessLogic;
import java.sql.SQLException;
import java.util.ArrayList;

import DataAccess.*;
import Model.Book;
import Model.User;

public class BookLogic {

	BookAccess b = new BookAccess();
	//BookLogic book = new BookLogic();
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
	public String show(String user)
	{
		String result1=b.showBooks1(user);
		return result1;
	}
	public String available(String username,String title) throws SQLException
	{
		//String result="";
		boolean ok = b.availabilty(title);
		if(ok==true) 
		{
			b.addBook(username, title);
		}
		return null;
	}
	/*public String add(String user, String title)
	{
		if(available(title).equals(null))
		{
			System.out.println("Cartea nu e diponibila");
		}
		else {
			try {
				b.addBook(user, title);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return title;
	}*/
	
}
