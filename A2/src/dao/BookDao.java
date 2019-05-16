package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import Test.Mail;

import java.sql.Statement;
import connection.Conn;
import model.Book;
import model.User;

public class BookDao implements Observer {

	StaffDao b = new StaffDao();
	private static Connection con = Conn.getConnection();

	public ArrayList<String> showBooks() throws SQLException {

		String query = "Select * from books";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		ArrayList<String> bookss = new ArrayList<String>();
		while (result.next()) {
			String unu = result.getString(2) + " - " + result.getString(3);
			bookss.add(unu);
			// b.addObserver(bookss);

		}
		b.addObserver(this);
		return bookss;
	}

	public String showBooks1(String username) {
		try {
			String query = "Select * from books where title = '" + username + "';";
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				return result.getString(2) + "\n";
			}
		} catch (Exception e) {

			System.out.println("Conection failed!");
		}
		return username;
	}

	public String genreRecomandation(String genre) {
		try {
			String query = "Select * from books where genre = '" + genre + "' limit 1";
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				return result.getString(3) + " - " + result.getString(2) + "\n";
			}
		} catch (Exception e) {

			System.out.println("Conection failed!");
		}
		return null;
	}

	public void addBook(String username, String title) throws SQLException {
		java.sql.PreparedStatement statement = null;
		String query = "Insert into reading (username, title) values (?,?)";
		statement = con.prepareStatement(query);
		statement.setString(1, username);
		statement.setString(2, title);
		statement.executeUpdate();
	}

	public void addBookRequest(String username, String title) throws SQLException {
		java.sql.PreparedStatement statement = null;
		String query = "Insert into waitinglist (email, title) values (?,?)";
		statement = con.prepareStatement(query);
		statement.setString(1, username);
		statement.setString(2, title);
		statement.executeUpdate();
	}

	public boolean availabilty(String title) {
		try {
			String query = "Select * from books where title ='" + title + "'";
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			result.next();
			int numberOfBooks = result.getInt(7);
			if (numberOfBooks > 0)
				return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	// public void addToWaitingList(String email, String title)
	// {
	// try {
	// java.sql.CallableStatement myStmt=userAccess.getCon().prepareCall("{call
	// add_waiting(?,?)}");
	// myStmt.setString(1,email);
	// myStmt.setString(2,title);
	// myStmt.execute();
	// } catch (SQLException e) {
	//
	// e.printStackTrace();
	// }
	// }
	public String verifyPayment(String email) throws SQLException {

		String query = "Select payed from payments where email = '" + email + "';";
		Statement statement1 = con.createStatement();
		ResultSet result = statement1.executeQuery(query);
		result.next();
		String payed = result.getString(1);
		return payed;
	}

	@Override
	public void update(Observable o, Object arg) {

		System.out.println(this.toString() + "is notified successfully about the availability of " + o.toString());
		try {
			Mail.SendMail("biancadondas21@gmail.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//

	// public void addReturn(String email, String title)
	// {
	// try {
	// java.sql.CallableStatement myStmt=userDAO.getCon().prepareCall("{call
	// add_return(?,?)}");
	//
	// myStmt.setString(1,email);
	// myStmt.setString(2,title);
	// myStmt.execute();
	// } catch (SQLException e) {
	//
	// e.printStackTrace();
	// }
	// }
}
