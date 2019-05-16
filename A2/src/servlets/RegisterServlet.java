package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO user;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        user = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp= request.getRequestDispatcher("/CreateAccount.jsp");
		reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name  = request.getParameter("first");
		String surname =  request.getParameter("last");
		String email = request.getParameter("username");
		String parola = request.getParameter("password");
		String parola1 = request.getParameter("password1");
		String payment = request.getParameter("payment");
		String title  = "user";
		//System.out.println(name + surname + test1 + test2 + test3);
		
		if(!name.equals(null))
			if(parola1.equals(parola1))
				try {
					user.insertUser(name, surname, email, parola, title);
					user.addPayment(email, payment);
					  RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
					  view.forward(request, response);
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			
//		UserDAO user = new UserDAO();
//		 try {
//				user.insertUser(name,surname,test1,test2, test3);
//				//forward=REGISTER_SUCCESS;
//			} catch (ClassNotFoundException | SQLException e) {
//				//forward=REGISTER_FAILURE;
//				e.printStackTrace();
//			}
	}

}
