package cqrs.ReadModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.Conn;

public class BookReadModel {

	private static Connection con = Conn.getConnection();
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		BookReadModel.con = con;
	}

	public ArrayList<String> showBooks() throws SQLException {

		String query = "Select * from books";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		ArrayList<String> bookss = new ArrayList<String>();
		while (result.next()) {
			String unu = result.getString(2) + " - " + result.getString(3);
			bookss.add(unu);

		

		}
	
		return bookss;
	}
	
	public void isAvailable(String title) throws SQLException
	{
		String query = "Select availability from books where title = '" + title+"'";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		result.next();
		System.out.println(result.getString(1));

	}
	public void changeToFree(String title) throws SQLException
	{
		String query = "update books set availability = 'free' where title = '" + title+"'";
		PreparedStatement ps = null;
		ps=con.prepareStatement(query);
		ps.execute();		
	}
	public void changeToTaken(String title) throws SQLException
	{
		String query = "update books set availability = 'taken' where title = '" + title+"'";
		PreparedStatement ps = null;
		ps=con.prepareStatement(query);
		ps.execute();		
	}

	
}
