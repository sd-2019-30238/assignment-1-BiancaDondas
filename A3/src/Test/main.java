package Test;

import java.sql.SQLException;

import cqrs.ReadModel.LoginCheck;

public class main {

	public static void main(String[] args)
	{
		LoginCheck a = new LoginCheck();
		try {
			System.out.println(a.searchUser("staff", "parola"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
