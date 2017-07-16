import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

import static org.hamcrest.CoreMatchers.is;

public class RentalsTotalAmountCalculatorTest
{


  @Test
  public void totalsFor_SingleNewReleaseStatement() {

    Vector<Rental> rentals = new Vector<>();
    rentals.add(new Rental (aNewReleaseMovie(), 3));

    double total = new RentalsTotalAmountCalculator().total(rentals);

    Assert.assertThat(total,is(9d));
  }

  @Test
  public void totalsFor_DualNewReleaseStatement() throws Exception
  {
    Vector<Rental> rentals = new Vector<>();
    rentals.add(new Rental (aNewReleaseMovie(), 3));
    rentals.add(new Rental (aNewReleaseMovie(), 3));

    double total = new RentalsTotalAmountCalculator().total(rentals);

    Assert.assertThat(total,is(18d));
  }

  @Test
  public void totalsFor_SingleChildrensStatement() throws Exception
  {
    Vector<Rental> rentals = new Vector<>();
    rentals.add(new Rental (aChildrenMovie(), 3));

    double total = new RentalsTotalAmountCalculator().total(rentals);

    Assert.assertThat(total,is(1.5d));
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