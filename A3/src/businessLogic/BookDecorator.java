package businessLogic;

import java.util.List;

import businessLogic.dto.Book;

public abstract class BookDecorator implements ITarget {

	private ITarget ITarget;
	
	public BookDecorator(ITarget iTarget) {
		this.ITarget = iTarget;
	}

	public BookDecorator() {
		// TODO Auto-generated constructor stub
	}

	public ITarget getITarget() {
		return ITarget;
	}

	public void setITarget(ITarget iTarget) {
		this.ITarget = iTarget;
	}

	@Override
	public void changeOwnership(String title, String available) {
		ITarget.changeOwnership(title, available);
		
	}


}
