import java.util.Enumeration;
import java.util.Vector;

public class Statement
{
	private String name;
	private Vector rentals = new Vector ();

	private TotalAmountCalculator totalAmountCalculator;
	private FrequentFlyerCalculator frequentFlyerCalculator;

	public Statement(String name,
		TotalAmountCalculator totalAmountCalculator,
		FrequentFlyerCalculator frequentFlyerCalculator)
	{
		this.name = name;
		this.totalAmountCalculator = totalAmountCalculator;
		this.frequentFlyerCalculator = frequentFlyerCalculator;
	}
	
	public void addRental (Rental rental) {
		rentals.addElement (rental);
	}
	
	public String getName () {
		return name;
	}
	
	public String create() {

		double totalAmount = totalAmountCalculator.total(this.rentals);
		int frequentRenterPoints = frequentFlyerCalculator.total(this.rentals);

		return header() + footerWithTotals(totalAmount, frequentRenterPoints);
	}

	private String footerWithTotals(double totalAmount, int frequentRenterPoints)
	{
		String statementFooter ="";
		statementFooter += "You owed " + String.valueOf (totalAmount) + "\n";
		statementFooter += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
		return statementFooter;
	}

	private String header()
	{
		String 				statementHeader 					= "Rental Record for " + getName () + "\n";
		Enumeration rentals = this.rentals.elements ();
		while (rentals.hasMoreElements ()) {
			Rental 		rental = (Rental) rentals.nextElement ();

			statementHeader += "\t" + rental.movieTitle() + "\t"
				+ String.valueOf (rental.amount()) + "\n";

		}
		return statementHeader;
	}

}