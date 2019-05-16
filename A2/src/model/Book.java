package model;

import java.util.Observable;
import java.util.Observer;

public class Book {
	private String name, author, releaseDate, genre, description;
	private int bookId, numberBooks;

	public Book(String name, String author, String releaseDate, String genre, String description, int bookId,
			int numberBooks) {
		super();
		this.name = name;
		this.author = author;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.description = description;
		this.bookId = bookId;
		this.numberBooks = numberBooks;
	}

	public Book(String name, int numberBooks) {
		this.name = name;
		this.numberBooks = numberBooks;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public int getNumberBooks() {
		return numberBooks;
	}

	public void setNumberBooks(int numberBooks) {
		this.numberBooks = numberBooks;
		// if(this.numberBooks>0) {
		//// this.setChanged();
		//// this.notifyObservers();
		// }

	}

	// @Override
	// public synchronized void deleteObserver(Observer o) {
	// System.out.println("Un-subscribing "+ o.toString() + " from notification of "
	// +
	// this.toString());
	// super.deleteObserver(o);
	// }
	// @Override
	// public void notifyObservers() {
	// System.out.println("Notifying observers for availability of " +
	// this.toString());
	// super.notifyObservers();
	// this.deleteObservers();
	// }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}