package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDao;

/**
 * Servlet implementation class ModifyStock
 */
@WebServlet("/ModifyStock")
public class ModifyStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyStock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp= request.getRequestDispatcher("/ModifyStock.jsp");
		reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String st = request.getParameter("Stock");
		System.out.println(st);
		 int stock = Integer.parseInt(st);
		System.out.println(stock);
		StaffDao s = new StaffDao();
		try {
			s.modifyStock(title,stock);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher("/ModifyStock.jsp");
	    view.forward(request, response);
	}

	private int parseInt(String parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
