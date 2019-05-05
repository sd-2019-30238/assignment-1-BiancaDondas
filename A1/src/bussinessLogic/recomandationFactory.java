package bussinessLogic;

public class recomandationFactory {
	
	public Recomandations gettReco(String type)
	{
		if(type.equalsIgnoreCase("Trends"))
			return new Trends();
		else if(type.equalsIgnoreCase("Genres"));
			return new Genres();
	}

}
