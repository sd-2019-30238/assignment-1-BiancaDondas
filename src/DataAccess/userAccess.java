package DataAccess;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class userAccess {
	private static Connection con=Conn.getConnection();
	public void showUsers() {
		try {
			String query="Select * from users";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}
					
		}catch(Exception e) {
			
			System.out.println("Conection failed!");
		}	  
	}
	
	public void addUser(String firstName, String surname, String mail, String password)
	{
			try {
				java.sql.CallableStatement myStmt=userAccess.con.prepareCall("{call add_user(?,?,?,?)}");
				
				myStmt.setString(1,firstName);
				myStmt.setString(2,surname);
				myStmt.setString(3,mail);
				myStmt.setString(4,password);
				myStmt.execute();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	public int login(String mail, String pass)
	{
		try {
		
			String query="Select * from users where email='" + mail+"'and parola = md5('"+pass+"');";
			String query3 ="Select * from users where email='" +mail+"'";
			String query1="Select * from users where parola= md5('"+pass+"');";
			String query2="Select * from users where parola= md5('";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			ResultSet result1=statement.executeQuery(query3);
			int startPos = query2.length();
			int length = query1.indexOf("');");
			String sub = query1.substring(startPos, length);
			/*while(result1.next()) {
				System.out.println(result1.getString(3));
			}*/
			result1.next();
			
			//System.out.println(result1.getStatement());
			
			if(mail.equals(result1.getString(3)))
			{
				if( pass.equals(sub))
				
					{
						if(result1.getString(5).equals(null) || result1.getString(5).equals(""))
							return 1;
							//System.out.println("user");
						else if(result1.getString(5).equals("staff"))
							return 2;
					//else mesaj de eroare  
					}
				//else System.out.println("staff");
			}
			//else mesaj eroare username
			
						//	System.out.println("Connection succeeded");
		}catch(Exception e) {

			System.out.println(e);
		}
		return 0;
	}
	
}
