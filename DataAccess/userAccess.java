package DataAccess;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class userAccess {
	private static Connection con=Conn.getConnection();
	public void showUsers() {
		try {
			String query="Select * from user";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}
					
		}catch(Exception e) {
			
			System.out.println("Conection failed!");
		}	  
	}
	
	public void addUser(int id, String firstName, String surname, String mail)
	{
			try {
				java.sql.CallableStatement myStmt=userAccess.con.prepareCall("{call add_user(?,?,?,?)}");
				myStmt.setInt(1, id);
				myStmt.setString(2, firstName);
				myStmt.setString(3,surname);
				myStmt.setString(4,mail);
				myStmt.execute();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	public void login(String mail, String pass)
	{
		try {
		
			String query="Select * from user where mail= '" + mail+"'and password = md5('"+pass+"');";
			String query1="Select * from user where password= md5('"+pass+"');";
			String query2="Select * from user where password= md5('";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			result.next();
			int startPos = query2.length();
			int length = query1.indexOf("');");
			String sub = query1.substring(startPos, length);
			if(mail.equals(result.getString(4)))
					if( pass.equals(sub))
							System.out.println("Connection succeeded");
		}catch(Exception e) {

			System.out.println("Incorect username or password");
		}	 
	}
}
