package cqrs.writeModel;
import businessLogic.dto.User;
public class RegisterUserCommand implements ICommand {

	private User UserInfo;
	private String type;
	
	public RegisterUserCommand(User user) {
		this.setUserInfo(user);
		this.setType("addUser");
	}
	
	public User getUserInfo() {
		return UserInfo;
	}

	public void setUserInfo(User userInfo) {
		UserInfo = userInfo;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
