package BusinessLogic;
import java.sql.SQLException;
import java.util.ArrayList;

import DataAccess.*;
import Model.Book;

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
	
	public boolean available(String title)
	{
		boolean ok = b.availabilty(title);
		return ok;
	}
}
