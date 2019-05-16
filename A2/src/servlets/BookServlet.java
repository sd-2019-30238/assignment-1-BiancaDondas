package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;
import connection.Conn;
import dao.BookDao;
/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	      throws ServletException, IOException {
//    	    response.setContentType("text/html");
//    	    PrintWriter out = response.getWriter();
//    	    out.println("<html>");
//    	    out.println("<head><title>All Employees</title></head>");
//    	    out.println("<body>");
//    	    out.println("<center><h1>All Employees</h1>");
//    	    Connection conn = null;
//    	    Statement stmt = null;
//    	    try {
//    	      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//    	      conn = DriverManager.getConnection("jdbc:odbc:Employees");
//    	      stmt = conn.createStatement();
//    	      String orderBy = request.getParameter("sort");
////    	      if ((orderBy == null) || orderBy.equals("")) {
////    	        orderBy = "SSN";
////    	      }
////    	      String orderByDir = request.getParameter("sortdir");
////    	      if ((orderByDir == null) || orderByDir.equals("")) {
////    	        orderByDir = "asc";
////    	      }
//    	      String query = "Select * from books";
//    	      ResultSet rs = stmt.executeQuery(query);
//    	      while (rs.next()) {
////    	        long employeeSSN = rs.getLong("SSN");
////    	        String employeeName = rs.getString("Name");
////    	        long employeeSalary = rs.getLong("Salary");
////    	        Date employeeHiredate = rs.getDate("Hiredate");
////    	        String employeeLocation = rs.getString("Location");
////    	        out.print(employeeSSN + "::");
////    	        out.print(employeeName + "::");
////    	        out.print(employeeSalary + "::");
////    	        out.print(employeeHiredate + "::");
////    	        out.print(employeeLocation + "::");
//    	    	  String title = rs.getString(2);
//    	    	  String author = rs.getString(3);
//    	    	  out.print(title + "::");
//      	        out.print(author + "::");
//    	      }
//    	    } catch (SQLException e) {
//    	      out.println("An error occured while retrieving " + "all books: " 
//    	          + e.toString());
//    	    } catch (ClassNotFoundException e) {
//    	      throw (new ServletException(e.toString()));
//    	    } finally {
//    	      try {
//    	        if (stmt != null) {
//    	          stmt.close();
//    	        }
//    	        if (conn != null) {
//    	          conn.close();
//    	        }
//    	      } catch (SQLException ex) {
//    	      }
//    	    }
//    	    out.println("</center>");
//    	    out.println("</body>");
//    	    out.println("</html>");
//    	    out.close();
    	    
    		String title = request.getParameter("bookTitle");
    		String user = request.getParameter("username");
    		BookDao b = new BookDao();
    		if(b.availabilty(title))
				try {
					b.addBook(user, title);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			else 
    		{
				try {
					b.addBookRequest(user, title);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				StringBuilder builder = new StringBuilder();
				builder.append("alert(ceva)");
				
//    			PrintWriter out = response.getWriter();  
//    			response.setContentType("text/html");  
    			//out.println("<script type=\"text/javascript\">");  
    			//out.println("alert('Your book is not in stock. You will recive an email when the book will be available');");  
    			//out.println("</script>");
    		}
    		RequestDispatcher view= request.getRequestDispatcher("/welcome.jsp");
	         view.forward(request, response);
    		//System.out.println(title + user);
    	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println(request.getUserPrincipal());
	
		//doGet(request, response);
	}

}
