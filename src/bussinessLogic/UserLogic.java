package bussinessLogic;
import java.sql.SQLException;
import java.util.ArrayList;

import dataAccess.*;
public class UserLogic {

	userAccess user = new userAccess();
	public int adaugaClient(String nume, String surname, String email, String pass, String payed, String string) {
		int n=1;
		string = "Yes";
		if( nume.equals("")|| surname.equals("")||email.equals("")) {
			n=0;
		} 
		if(n==1) {
			userAccess m=new userAccess();
			m.addUser(nume,surname,email, pass);
			m.addPayment(email, payed,string);
		}
		return n;
	}
	public int logare(String mail, String pass)
	{
		userAccess user = new userAccess();
		int ok = user.login(mail, pass);
		return ok;
	}
	public int adaugaPay(String email, String payment) {
		int n=1;
		if( email.equals("") || payment.equals("")) {
			n=0;
		} 
		if(n==1) {
			userAccess m=new userAccess();
			m.addPayment(email, payment, "Yes");
		}
		return n;
	}

	public void returnBook(String email, String title)
	{
		userAccess user = new userAccess();
		user.returnBook(email, title);
	}
	
	public ArrayList<String> Waiting()
	{
		try {
			ArrayList<String> result= user.showWaiting();
			return result;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 	
	}
}
