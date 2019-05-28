package cqrs.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import businessLogic.dto.Book;
import businessLogic.dto.User;
import connection.Conn;
import cqrs.writeModel.BookCommand;
import cqrs.writeModel.ICommand;
import cqrs.writeModel.RegisterUserCommand;

public class RegisterUserHandler implements IHandler{

	
	private String type;
	private static Connection con = Conn.getConnection();
	public RegisterUserHandler() {
		this.setType("addUser");
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		RegisterUserHandler.con = con;
	}

public String handle(ICommand userCommand) {
		
		
		User user = ((RegisterUserCommand) userCommand).getUserInfo();
		String prenume = user.getFirstName();
		String nume = user.getSurname();
		String email = user.getEmail();
		String parola = user.getPassword();
		String title = user.getTip();
		//String method = user.getMethod();
		System.out.println("aici");
		int ok =0;
		try {
			PreparedStatement pr = con.prepareStatement("insert into users values (?,?,?,?,?)");
			ok=1;
			pr.setString(1, prenume);
			pr.setString(2, nume);
			pr.setString(3, parola);
			pr.setString(4, email);
			pr.setString(5, title);
			pr.executeUpdate();
			System.out.println("user inserted");
			pr.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ok);
		if(ok==1) return "success";
		return "failure";

	}
	
}
