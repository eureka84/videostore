import java.util.Enumeration;
import java.util.Vector;

public class Statement
{
	private String name;
	private Vector rentals = new Vector ();
	private double totalAmount;
	private int frequentRenterPoints;

	public Statement(String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.addElement (rental);
	}
	
	public String getName () {
		return name;
	}
	
	public String create() {
		totalAmount = 0;
		frequentRenterPoints = 0;
		Enumeration 		rentals 				= this.rentals.elements ();
		String 				result 					= "Rental Record for " + getName () + "\n";
		
		while (rentals.hasMoreElements ()) {
			double 		thisAmount = 0;
			Rental 		rental = (Rental)rentals.nextElement ();

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

	private double amountFor(Rental each)
	{
		double thisAmount =0;
		// determines the amount for each line
		switch (each.getMovie ().getPriceCode ()) {
      case Movie.REGULAR:
        thisAmount += 2;
        if (each.getDaysRented () > 2)
          thisAmount += (each.getDaysRented () - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        thisAmount += each.getDaysRented () * 3;
        break;
      case Movie.CHILDRENS:
        thisAmount += 1.5;
        if (each.getDaysRented () > 3)
          thisAmount += (each.getDaysRented () - 3) * 1.5;
        break;
    }
		return thisAmount;
	}

	public double totalAmount()
	{
		return totalAmount;
	}

	public int frequentFliersPoints()
	{
   return frequentRenterPoints;
	}
}