
import java.util.Vector;
import java.util.Enumeration;

public class Customer 
{
	private String name;
	private Vector rentals = new Vector ();

	public Customer (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.addElement (rental);
	}
	
	public String getName () {
		return name;
	}
	
	public String statement () {
		double 				totalAmount 			= 0;
		int					frequentRenterPoints 	= 0;
		Enumeration 		rentals 				= this.rentals.elements ();
		String 				result 					= "Rental Record for " + getName () + "\n";
		
		while (rentals.hasMoreElements ()) {
			double 		thisAmount = 0;
			Rental 		rental = (Rental)rentals.nextElement ();
			
			// determines the amount for rental line
			thisAmount = amountFor(rental);

			frequentRenterPoints++;
			
			if (rental.getMovie ().getPriceCode () == Movie.NEW_RELEASE
					&& rental.getDaysRented () > 1)
				frequentRenterPoints++;
				
			result += "\t" + rental.getMovie ().getTitle () + "\t"
								+ String.valueOf (thisAmount) + "\n";
			totalAmount += thisAmount;
				
		}
		
		result += "You owed " + String.valueOf (totalAmount) + "\n";
		result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";
		
		
		return result;
	}

	private double amountFor(Rental rental)
	{
		double result =0;
		switch (rental.getMovie ().getPriceCode ()) {
      case Movie.REGULAR:
        result += 2;
        if (rental.getDaysRented () > 2)
          result += (rental.getDaysRented () - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        result += rental.getDaysRented () * 3;
        break;
      case Movie.CHILDRENS:
        result += 1.5;
        if (rental.getDaysRented () > 3)
          result += (rental.getDaysRented () - 3) * 1.5;
        break;
    }
		return result;
	}

}