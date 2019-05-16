package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDao;

/**
 * Servlet implementation class ValidateReturn
 */
@WebServlet("/ValidateReturn")
public class ValidateReturn extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateReturn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp= request.getRequestDispatcher("/ValidateReturn.jsp");
		reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		StaffDao s = new StaffDao();
		String next = null;
		s.deleteReturn(email, title); 
		try {
			next = s.searchWaiting(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(!next.equals(null))
			{
				s.forObs(email, title);
//				s.deleteWaiting(email, title);
//				s.addReadingList(email, title);
//				this.setChanged();
//			this.notifyObservers();
				
			}
		
		RequestDispatcher view = request.getRequestDispatcher("/ValidateReturn.jsp");
	    view.forward(request, response);
	}
//	@Override
//	public synchronized void deleteObserver(Observer o) {
//	System.out.println("Un-subscribing "+ o.toString() + " from notification of " +
//	this.toString());
//	super.deleteObserver(o);
//	}
//	@Override
//	public void notifyObservers() {
//		System.out.println("Notifying observers for availability of " + this.toString());
//		super.notifyObservers();
//		this.deleteObservers();
//	}

}
