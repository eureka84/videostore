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
      frequentRenterPoints++;

      if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
        && rental.getDaysRented() > 1)
      {
        frequentRenterPoints++;
      }
    }

    return frequentRenterPoints;
  }
}
