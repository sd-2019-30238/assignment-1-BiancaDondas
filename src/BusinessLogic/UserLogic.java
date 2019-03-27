package BusinessLogic;
import DataAccess.*;
public class UserLogic {

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

}
