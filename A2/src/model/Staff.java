package model;

import java.util.Observable;
import java.util.Observer;

import dao.Mail;

public class Staff {
	private int idStaff;
	private String firstName, surname;

	public Staff(int idStaff, String firstName, String surname) {
		super();
		this.idStaff = idStaff;
		this.firstName = firstName;
		this.surname = surname;
	}

	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
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

}