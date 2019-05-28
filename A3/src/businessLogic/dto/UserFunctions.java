package businessLogic.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Conn;

public class UserFunctions {

	private static Connection con = Conn.getConnection();

	public void insertUser(String name, String surname, String email, String parola, String title)
			throws SQLException, ClassNotFoundException {
		PreparedStatement pr = con.prepareStatement("insert into users values (?,?,?,?,?)");

		pr.setString(1, name);
		pr.setString(2, surname);
		pr.setString(3, parola);
		pr.setString(4, email);
		pr.setString(5, title);
		pr.executeUpdate();
		System.out.println("user inserted");
		pr.close();
	}

}
