package model;

public class User {
		private String firstName, surname,email, password;
		public User(String firstName, String surname, String email, String pass) {
			this.firstName = firstName;
			this.surname = surname;
			this.email = email;
			this.password = pass;
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
