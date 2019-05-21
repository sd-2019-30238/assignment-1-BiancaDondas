package dao;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import connection.Conn;
import model.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaffDao  {

	private static Connection con = Conn.getConnection();

	public ArrayList<String> showReturned() throws SQLException {
		String query = "Select * from returnrequest";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		ArrayList<String> persons = new ArrayList<String>();
		while (result.next()) {
			String pers = result.getString(1) + " " + result.getString(2);
			persons.add(pers);
		}
		return persons;
	}

	public void modifyPayment(String email, String payed) {

		try {
			java.sql.CallableStatement myStmt = UserDAO.getCon().prepareCall("{call verify_payment(?,?)}");
			myStmt.setString(1, payed);
			myStmt.setString(2, email);
			myStmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void deleteReading(String email, String title) {
		java.sql.PreparedStatement st = null;
		int res = 0;
		try {
			String query = "Delete from reading where username='" + email + "' and title = '" + title + "';";
			st = con.prepareStatement(query);
			st.executeUpdate();
			res = st.executeUpdate();
		} catch (Exception e) {
			System.out.println("no database " + e);
		}

	}

	public void deleteReturn(String email, String title) {
		java.sql.PreparedStatement st = null;
		int res = 0;
		try {
			String query = "Delete from returnrequest where email=" + "'" + email + "' and booktitle = '" + title
					+ "';";
			st = con.prepareStatement(query);
			st.executeUpdate();
			res = st.executeUpdate();
		} catch (Exception e) {
			System.out.println("no database " + e);
		}

	}

	public void deleteWaiting(String email, String title) {
		java.sql.PreparedStatement st = null;
		int res = 0;
		try {
			String query = "Delete from waitinglist where email=" + "'" + email + "' and title = '" + title + "';";
			st = con.prepareStatement(query);
			st.executeUpdate();
			res = st.executeUpdate();
		} catch (Exception e) {
			System.out.println("no database " + e);
		}

	}

	public void modifyStock(String title, int nr) throws SQLException {
		try {
			java.sql.CallableStatement myStmt = UserDAO.getCon().prepareCall("{call change_stock(?,?)}");
			myStmt.setString(1, title);
			myStmt.setInt(2, nr);

			myStmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void addReadingList(String email, String title) throws Exception {
		//Mail email1 = new Mail();
	
		try {
			java.sql.CallableStatement myStmt = UserDAO.getCon().prepareCall("{call add_reading(?,?)}");
			myStmt.setString(1, email);
			myStmt.setString(2, title);
			myStmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public String searchWaiting(String title) throws SQLException {
		String query = "Select email from waitinglist where title = '" + title + "' limit 1";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		result.next();
		String s = result.getString(1);
		return s;
	}

	public ArrayList<String> getFromWaiting() throws SQLException {

		String query = "Select * from waitinglist limit 1";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		ArrayList<String> waitingPerson = new ArrayList<String>();
		// ArrayList<String[]> authors=new ArrayList<String[]>();
		Book b = new Book();
		while (result.next()) {
			String unu = result.getString(1);
			String doi = result.getString(2);
			waitingPerson.add(unu);
			waitingPerson.add(doi);
		}
		return waitingPerson;
	}

	public void forObs(String email, String title) throws Exception {
		// StaffDao s = new StaffDao();
		deleteWaiting(email, title);
		addReadingList(email, title);
		//Mail.SendMail(email);
		//notifyObservers(email);
//		this.setChanged();
//		this.notifyObservers();
	}

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		StaffDao.con = con;
	}

//	@Override
//	public synchronized void addObserver(Observer o) {
//		System.out.println("Subscribing " + o.toString() + " for notification of " + this.toString());
//		super.addObserver(o);
//	}
//
//	@Override
//	public synchronized void deleteObserver(Observer o) {
//		System.out.println("Un-subscribing " + o.toString() + " from notification of " + this.toString());
//		super.deleteObserver(o);
//	}
//
//	@Override
//	public void notifyObservers() {
//		System.out.println("Notifying observers for availability of " + this.toString());
//		super.notifyObservers();
//		this.deleteObservers();
//	}

}
