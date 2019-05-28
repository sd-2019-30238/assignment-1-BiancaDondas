package businessLogic.dto;

public class User {
	private String firstName, surname, email, password, tip;

	
	public User(String firstName, String surname, String email, String password, String type) {
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.tip = type;
	}
	
	public User() {
	}

	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public User(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
