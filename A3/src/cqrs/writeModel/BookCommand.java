package cqrs.writeModel;

import businessLogic.dto.Book;

public class BookCommand implements ICommand{

	private Book bookInfo;
	private String type;
	public BookCommand(Book book) {
		this.setBookInfo(book);
		this.setType("addBook");
	}
	
	public Book getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(Book bookInfo) {
		this.bookInfo = bookInfo;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
