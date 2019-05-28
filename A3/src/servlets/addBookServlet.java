package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.Mediator;
import businessLogic.dto.*;
import cqrs.writeModel.bookWriteModel;
/**
 * Servlet implementation class addBookServlet
 */
@WebServlet("/addBookServlet")
public class addBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private bookWriteModel writeModel;
    public addBookServlet() {
        super();
        Mediator mediator = new Mediator();
        this.writeModel = new bookWriteModel(mediator);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp= request.getRequestDispatcher("/AddBook.jsp");
		reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String gen = request.getParameter("genre");
		String data = request.getParameter("date");
		String descriere = request.getParameter("description");
		String stock = request.getParameter("stock");
		int stoc = Integer.parseInt(stock);
		
		Book book = new Book();
		book.setId(id);
		book.setName(title);
		book.setAuthor(author);
		book.setGenre(gen);
		book.setReleaseDate(data);
		book.setDescription(descriere);
		book.setNumberBooks(stoc);
		
		String result = writeModel.addBook(book);
		if(result.equals("success"))
		{
			System.out.println("book inserted");
		}
		else 
		{
			System.out.println("error message");
		}
		
	}

}
