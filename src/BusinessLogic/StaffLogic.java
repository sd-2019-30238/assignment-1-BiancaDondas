package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import DataAccess.StaffAccess;

public class StaffLogic {
	
	StaffAccess staff = new StaffAccess();
	public void verifyPayed(String email, String payed)
	{
		staff.modifyPayment(email, payed);
	}
	public void bookReturn(String email, String title)
	{

		staff.deleteReading(email, title);
		staff.returnBook(email, title);
	}
	public ArrayList<String> showReturnedBook() throws SQLException
	{
		ArrayList<String> result = staff.showReturned();
		return result;
	}
	public void verifyReturn(String email, String title) throws SQLException
	{
		//staff.deleteReading(email, title);
		staff.deleteReturn(email, title);
		String firstEmail=staff.getFromWaiting().get(0);
		String firsttitle=staff.getFromWaiting().get(1);
		staff.addReadingList(firstEmail, firsttitle);
		staff.deleteWaiting(email, title);
	}
}
