package Test;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.BookLogic;
import DataAccess.*;
import presentationLayer.ReadingList;
public class Main {

	static userAccess conex = new userAccess();
	static BookAccess books = new BookAccess();
	static BookLogic b = new BookLogic();
	
	public static void main(String args[]) throws SQLException
	{
		 books.verifyPayment("bobo");
	}
}
