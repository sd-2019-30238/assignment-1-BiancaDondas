package businessLogic.dto;

public class Book {
	private String name, author, releaseDate, genre, description, id;
	private int bookId, numberBooks;

	public Book(String id, String name, String author, String releaseDate, String genre, String description, int bookId,
			int numberBooks) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.description = description;
		this.bookId = bookId;
		this.numberBooks = numberBooks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Book(String name, int numberBooks) {
		this.name = name;
		this.numberBooks = numberBooks;
	}

	public Book() {
	}

	public int getNumberBooks() {
		return numberBooks;
	}

	public void setNumberBooks(int numberBooks) {
		this.numberBooks = numberBooks;
	}
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
