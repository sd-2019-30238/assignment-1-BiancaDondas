package Test;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.BookLogic;
import BusinessLogic.StaffLogic;
import DataAccess.*;
import presentationLayer.ReadingList;
public class Main {

	static userAccess conex = new userAccess();
	static BookAccess books = new BookAccess();
	static BookLogic b = new BookLogic();
	static StaffAccess s = new StaffAccess();
	static StaffLogic ss = new StaffLogic();
	public static void main(String args[]) throws SQLException
	{
		// books.verifyPayment("bobo");
		 //books.addToWaitingList("ana", "dfnfd");
		//s.validateReturn("adacz", "ssss");
		//s.deleteReading("bobo", "ssss");
		//System.out.println(s.getFromWaiting().get(0));
		//ss.verifyReturn("bobo", "ssss");
		books.filterByTitle("ssss");
	}
}
