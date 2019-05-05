package bussinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import dataAccess.Book;
import dataAccess.BookAccess;

import java.util.Random;

public class Trends implements Recomandations{


	@Override
	public String getRecomandation(String trends) {
		 
	
		String item = "Recomended book: Aghata Christie Murder in Orient Express";
		return	item;
	}


	
}
