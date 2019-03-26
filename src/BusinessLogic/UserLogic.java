package BusinessLogic;
import java.sql.SQLException;

import DataAccess.*;
import Model.*;
public class UserLogic {

	public int adaugaClient(String nume, String surname, String email, String pass) {
		int n=1;
		if( nume.equals("")|| surname.equals("")||email.equals("")) {
			n=0;
		} 
		if(n==1) {
			User u=new User(nume, surname, email,pass);
			userAccess m=new userAccess();
			m.addUser(nume,surname,email, pass);
		}
		return n;
	}

}
