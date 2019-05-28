package businessLogic;

import java.sql.Connection;
import java.sql.SQLException;

import connection.Conn;
import cqrs.ReadModel.BookReadModel;

public class UnavailableDecorator extends BookDecorator{
	private static Connection con = Conn.getConnection();

	public UnavailableDecorator(ITarget iTarget) {
		super(iTarget);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void changeOwnership(String title, String available) {
	
		super.changeOwnership(title, available);
		myChange(title);
	}
	public void myChange(String title) {
		BookReadModel bookModel = new BookReadModel();
		try {
			bookModel.changeToTaken(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}

}
