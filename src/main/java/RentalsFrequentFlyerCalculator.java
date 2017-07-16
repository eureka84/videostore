import java.util.Enumeration;
import java.util.Vector;

public class RentalsFrequentFlyerCalculator implements FrequentFlyerCalculator
{

  @Override
  public int total(Vector rentals)
  {
    int frequentRenterPoints = 0;
    Enumeration rentals1 = rentals.elements();
    while (rentals1.hasMoreElements())
    {
      Rental rental = (Rental) rentals1.nextElement();
      frequentRenterPoints += rental.movie.totalFreqFliersPoints(rental.getDaysRented());
    }

    return frequentRenterPoints;
  }

}
