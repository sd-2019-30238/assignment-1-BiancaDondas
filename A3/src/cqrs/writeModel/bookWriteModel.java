package cqrs.writeModel;

import businessLogic.Mediator;
import businessLogic.dto.Book;
import cqrs.handlers.IHandler;
import cqrs.handlers.bookHandler;

public class bookWriteModel {

	private Mediator mediator;
	
	public bookWriteModel(Mediator mediator) {
		this.setMediator(mediator);
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	public String addBook(Book book)
	{
		ICommand command = new BookCommand(book);
		IHandler handler = new bookHandler();
		mediator.registerHandler(handler);
		return mediator.handle(command);
	}
}
