package businessLogic.dto;

public class User {
	private String firstName, surname, email, password, type;

	
	public User(String firstName, String surname, String email, String password, String type) {
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.type = type;
	}
	public User() {
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
