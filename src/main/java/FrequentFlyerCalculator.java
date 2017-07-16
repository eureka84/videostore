import java.util.Enumeration;
import java.util.Vector;

public class FrequentFlyerCalculator
{
  private final Vector rentals;

  public FrequentFlyerCalculator(Vector rentals)
  {

    this.rentals = rentals;
  }

  public int total()
  {
    int frequentRenterPoints = 0;
    Enumeration rentals1 = this.rentals.elements();
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
