package businessLogic.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.Mediator;
import businessLogic.dto.User;
import cqrs.writeModel.UserWriteModel;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private UserWriteModel writeModel;
    public RegisterServlet() {
        super();
        Mediator mediator = new Mediator();
        this.writeModel = new UserWriteModel(mediator);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name  = request.getParameter("first");
		String surname =  request.getParameter("last");
		String email = request.getParameter("username");
		String parola = request.getParameter("password");
		String title  = "user";
		
		User user = new User();
		user.setFirstName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setPassword(parola);
		user.setTip(title);
		//user.setMethod(payment);
		

		String res = writeModel.addUser(user);
		System.out.println("altundeva\n");
		System.out.println("result : "+res);
		if(res.equals("success"))
		{
			RequestDispatcher reqDisp= request.getRequestDispatcher("/login.jsp");
			reqDisp.forward(request, response);
		}
		else 
		{	System.out.println("user cannot be inserted");
		RequestDispatcher reqDisp= request.getRequestDispatcher("/CreateAccount.jsp");
		reqDisp.forward(request, response);
		}
	}

}
