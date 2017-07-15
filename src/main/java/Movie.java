

public class Movie
{
	public static final int CHILDRENS	= 2;
	public static final int REGULAR 	= 0;
	public static final int NEW_RELEASE = 1;
	
	private String title;
	private int priceCode;
	
	public Movie (String title, int priceCode) {
		this.title 		= title;
		this.priceCode 	= priceCode;
	}
	
	public int getPriceCode () {
		return priceCode;
	}
	
	public void setPriceCode (int code) {
		priceCode = code;
	}
	
	public String getTitle () {
		return title;
	}

	double amount(int daysRented, Rental rental)
	{
		double result =0;
		switch (getPriceCode ()) {
      case REGULAR:
        result += 2;
        if (rental.getDaysRented () > 2)
          result += (daysRented - 2) * 1.5;
        break;
      case NEW_RELEASE:
        result += rental.getDaysRented () * 3;
        break;
      case CHILDRENS:
        result += 1.5;
        if (rental.getDaysRented () > 3)
          result += (rental.getDaysRented () - 3) * 1.5;
        break;
    }
		return result;
	}
}