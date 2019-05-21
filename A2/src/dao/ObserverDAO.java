package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.Conn;
import model.User;

public class ObserverDAO {
	private static Connection con = Conn.getConnection();
	private UserDAO userDAO;

	public ObserverDAO(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	public void addObserver(long bookId, long userId) {
		try (PreparedStatement pr = con.prepareStatement("insert into bookUsersObserver values (?,?)");) {
			pr.setLong(1, bookId);
			pr.setLong(2, userId);
			pr.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void notifyObservers(String bookId) {
		String query = "Select userid from bookUsersObserver where bookid = ?";
		try (PreparedStatement statement = con.prepareStatement(query);) {
			statement.setString(1, bookId);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String userId = result.getString(1);
				// TODO
				 String user = userDAO.getUserById(userId);
				// Mail.SendMail("biancadondas21@gmail.com");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
