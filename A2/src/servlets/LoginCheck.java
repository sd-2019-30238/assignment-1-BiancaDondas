package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

import javax.servlet.RequestDispatcher;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO user;
	public LoginCheck() {
		super();
		user = new UserDAO();
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp= request.getRequestDispatcher("/login.jsp");
		reqDisp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String forward = "";
//
//		boolean result = false;
//		String u = request.getParameter("username");
//		String p = request.getParameter("password");
//		UserDAO user = new UserDAO();
//		
//		// if(u.equals("test") && p.equals("1234")) result = true;
//		System.out.println("aici1");
//		try {
//			if (user.searchUser(u, p) == true) {
//				forward = "/welcome.jsp";
//			} else {
//				forward = "/about.jsp";
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("aici");
//			e.printStackTrace();
//		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		RequestDispatcher view = request.getRequestDispatcher(forward);
//		view.forward(request, response);
		
		
		
		
//		String forward = "";
//		
//			//	int result = 2;
//				boolean result = false;
//					
//					try {
//						result = user.searchUser(
//						         request.getParameter("username"),
//						         request.getParameter("password"));
//					} catch (ClassNotFoundException | SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				
//		         if (result == true) {
//		             forward = "/welcome.jsp";}
////		         } else if(result == 0)
////		         {
////		        	 forward = "/staff.jsp";
////		         }
//		         else 
//		         {
//		             forward = "/about.jsp";
//		         }
//		
//		         RequestDispatcher view = request.getRequestDispatcher(forward);
//		         view.forward(request, response);
		
		
		String forward = "";
		
				int result = 2;
					
					try {
						result = user.searchUser(
						         request.getParameter("username"),
						         request.getParameter("password"));
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
		         if (result == 1) {
		             forward = "/welcome.jsp";
		         } else if(result == 0)
		         {
		        	 forward = "/staff.jsp";
		         }
		         else 
		         {
		             forward = "/about.jsp";
		         }
		
		         RequestDispatcher view = request.getRequestDispatcher(forward);
		         view.forward(request, response);
		         
		        
		
	}

	
}
