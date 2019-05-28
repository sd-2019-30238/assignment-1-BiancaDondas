package servlets;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cqrs.ReadModel.LoginCheck;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//LoginCheck user = new LoginCheck(); // functia cu operatia pt login(din read model)
    LoginCheck user = new LoginCheck();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp= request.getRequestDispatcher("/login.jsp");
		reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String result = "";
			
			try {
				result = user.searchUser(
				         request.getParameter("username"),
				         request.getParameter("password"));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
         if (result.equals("user")) {
             forward = "/welcome.jsp";
        	// System.out.println("regular user");
         } else if(result.equals("staff"))
         {
        	// System.out.println("admin");
        	 forward = "/staff.jsp";
         }
         else 
         {
        	// System.out.println("none");
             forward = "/about.jsp";
         }

         RequestDispatcher view = request.getRequestDispatcher(forward);
         view.forward(request, response);
         
	}

}
