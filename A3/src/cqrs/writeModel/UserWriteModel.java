package cqrs.writeModel;
import businessLogic.dto.User;
import businessLogic.Mediator;
import businessLogic.dto.Book;
import cqrs.handlers.IHandler;
import cqrs.handlers.RegisterUserHandler;
import cqrs.handlers.bookHandler;

public class UserWriteModel {

private Mediator mediator;
	
	public UserWriteModel(Mediator mediator) {
		this.setMediator(mediator);
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	public String addUser(User user)
	{
		ICommand command = new RegisterUserCommand(user);
		IHandler handler = new RegisterUserHandler();
		mediator.registerHandler(handler);
		return mediator.handle(command);
	}
}
