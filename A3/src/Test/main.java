package Test;

import java.sql.SQLException;

import businessLogic.dto.UserFunctions;
import cqrs.ReadModel.BookReadModel;
import cqrs.ReadModel.LoginCheck;
import cqrs.handlers.RegisterUserHandler;

public class main {

	public static void main(String[] args)
	{
		LoginCheck a = new LoginCheck();
		UserFunctions uf = new UserFunctions();
		BookReadModel book = new BookReadModel();
		try {
			//rr.handle(userCommand)
			//System.out.println(a.searchUser("staff", "parola"));
			//uf.insertUser("aaaaa", "aaaaaa", "gggg", "aaaaa", "staff");
			//book.isAvailable("Ion");
			book.changeToTaken("ana");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
