package bussinessLogic;

import dataAccess.BookAccess;

public class Genres implements Recomandations  {

	@Override
	public String getRecomandation(String genre) {
		BookAccess books = new BookAccess();
		return "Recomended book: " + books.genreRecomandation(genre);
	}	
}
