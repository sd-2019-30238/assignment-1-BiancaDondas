package businessLogic;

import java.sql.Connection;
import java.sql.SQLException;

import businessLogic.dto.Book;
import connection.Conn;
import cqrs.ReadModel.BookReadModel;

public class OwnedDecorator extends BookDecorator {
	private static Connection con = Conn.getConnection();

	public OwnedDecorator() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void changeOwnership(String title, String available) {

		//super.changeOwnership(title, available);
		myChange(title);
	}

	public void myChange(String title) {
		BookReadModel bookModel = new BookReadModel();
		try {
			bookModel.changeToFree(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
