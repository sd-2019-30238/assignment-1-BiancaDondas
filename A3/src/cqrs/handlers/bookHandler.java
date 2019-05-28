package cqrs.handlers;
import cqrs.writeModel.BookCommand;
import java.sql.Connection;
import java.sql.SQLException;

import businessLogic.dto.Book;
import connection.Conn;
import cqrs.writeModel.BookCommand;
import cqrs.writeModel.ICommand;

public class bookHandler implements IHandler{

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		bookHandler.con = con;
	}

	private String type;
	
	public bookHandler() {
		this.setType("addBook");
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private static Connection con = Conn.getConnection();
	
	public String handle(ICommand bookCommand) {
		
		
		Book book = ((BookCommand) bookCommand).getBookInfo();
		String id = book.getId();
		String title = book.getName();
		String author = book.getAuthor();
		String genre = book.getGenre();
		String releaseDate = book.getReleaseDate();
		String description = book.getDescription();
		int numberOfBooks = book.getNumberBooks();
		int ok =0;
		try {
			java.sql.PreparedStatement statement = null;
			String query = "Insert into books values (?,?,?,?,?,?,?)";
			ok=1;
			statement = con.prepareStatement(query);
			statement.setString(1, id);
			statement.setString(2, title);
			statement.setString(3, author);
			statement.setString(4, genre);
			statement.setString(5, releaseDate);
			statement.setString(6, description);
			statement.setInt(7, numberOfBooks);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ok==1) return "success";
		return "failure";

	}

	
	

}
