import org.junit.Test;

import java.util.Vector;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FrequentFlyerCalculatorTest
{

  @Test
  public void freqFliersPointsFor_SingleNewReleaseStatement() {

    Vector<Rental> rentals = new Vector<>();
    rentals.add(new Rental (aNewReleaseMovie(), 3));

    int total = new RentalsFrequentFlyerCalculator().total(rentals);
    assertThat(total, is(2));
  }
  @Test
  public void freqFliersPointsFor_DualNewReleaseStatement() {

    Vector<Rental> rentals = new Vector<>();
    rentals.add(new Rental (aNewReleaseMovie(), 3));
    rentals.add(new Rental (aNewReleaseMovie(), 3));

    int total = new RentalsFrequentFlyerCalculator().total(rentals);
    assertThat(total, is(4));
  }

  @Test
  public void freqFliersPointsFor_SingleChildrensStatement() {

    Vector<Rental> rentals = new Vector<>();
    rentals.add(new Rental (aChildrenMovie(), 3));

    int total = new RentalsFrequentFlyerCalculator().total(rentals);
    assertThat(total, is(1));
  }


  private Movie aNewReleaseMovie()
  {
    return new Movie ("The Cell", Movie.NEW_RELEASE);
  }


  private Movie aChildrenMovie()
  {
    return new Movie ("The Tigger Movie", Movie.CHILDRENS);
  }
}