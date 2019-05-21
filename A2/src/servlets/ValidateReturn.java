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

import dao.AppObserver;
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
		String m = "";
		s.deleteReturn(email, title); 
		try {
			m = s.searchWaiting(title);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			next = s.searchWaiting(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(!next.equals(null))
			{
				try {
					s.forObs(m, title);
					//System.out.println(m);
					AppObserver.availabilityObserver.sendMail(m);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
