import junit.framework.TestCase;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class VideoStoreTest extends TestCase
{
	public VideoStoreTest (String name) {
		super (name);
	}

	private Statement statement;

	protected void setUp ()  {
		statement = new Statement("Fred");
	}
	
	public void testSingleNewReleaseStatement () {
		statement.addRental (new Rental (aNewReleaseMovie(), 3));
		statement.create();
		assertTotalAmountAndFrequentFliersPoints(9d, 2);
	}

	public void testDualNewReleaseStatement () {
		statement.addRental (new Rental (aNewReleaseMovie(), 3));
		statement.addRental (new Rental (aNewReleaseMovie(), 3));

		statement.create();

		assertTotalAmountAndFrequentFliersPoints(18d, 4);
	}

	public void testSingleChildrensStatement () {
		statement.addRental (new Rental (aChildrenMovie(), 3));
		statement.create();

		assertTotalAmountAndFrequentFliersPoints(1.5, 1);
	}

	public void testMultipleRegularStatement () {
		statement.addRental (new Rental (aRegularMovie("Plan 9 from Outer Space"), 1));
		statement.addRental (new Rental (aRegularMovie("8 1/2"), 2));
		statement.addRental (new Rental (aRegularMovie("Eraserhead"), 3));

		assertEquals ("Rental Record for Fred\n" +
			"\tPlan 9 from Outer Space\t2.0\n" +
			"\t8 1/2\t2.0\n" +
			"\tEraserhead\t3.5\n" +
			"You owed 7.5\n" +
			"You earned 3 frequent renter points\n", statement.create());
	}

	private Movie aRegularMovie(String title)
	{
		return new Movie (title, Movie.REGULAR);
	}

	private void assertTotalAmountAndFrequentFliersPoints(double totalAmount,int frequentFliersPoints)
	{
		Assert.assertThat(statement.totalAmount(),is(totalAmount));
		Assert.assertThat(statement.frequentFliersPoints(), is(frequentFliersPoints));
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