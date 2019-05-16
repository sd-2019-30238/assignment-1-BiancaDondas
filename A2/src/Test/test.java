package Test;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.*;
import model.Book;
import model.User;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		try {
//			Mail.SendMail("czaada@gmail.com");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//Book b = new Book("Ion", 0);
//User p1 = new User("Ana");
//	b.addObserver(p1);
//	b.setNumberBooks(9);
	UserDAO u= new UserDAO();
	StaffDao o  =  new StaffDao();
	//System.out.println(u.getUserById("bbbb"));
	//o.modifyStock("ccc",12);
	//System.out.println(o.searchWaiting("Ion"));
	
		
	}
}
