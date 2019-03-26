package Test;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.BookLogic;
import DataAccess.*;
public class Main {

	static userAccess conex = new userAccess();
	static BookAccess books = new BookAccess();
	static BookLogic b = new BookLogic();
	//static User u = new User(1234,"Dana","Ionescu","danaionescu@gmail.com");
	public static void main(String args[])
	{
		 
		//conex.addUser("Dana", "Ionescu", "danaionescu@gmail.com", "1234");
		//conex.showUsers();
		//books.showBooks();
		conex.login("adacz", "1234");
		//books.filterByTitle("Clean Code");
		//conex.addUser("anaan", "dsfd", "sdvh", "kfndjgb");
		//b.filterAuthor("Robert Cecil Martin");
		
	/*	ArrayList<String[]> ar = null;
		try {
			ar = books.filterByAuthor("Robert Cecil Martin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ar);*/
		//b.filterAuthor("Robert Cecil Martin");
		books.availabilty("Clean Code");
	}
}
