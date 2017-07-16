import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class VideoStoreTest
{
	private Statement statement = new Statement("Fred");

	@Test
	public void totalsFor_SingleNewReleaseStatement() {
		statement.addRental (new Rental (aNewReleaseMovie(), 3));
		statement.create();
		assertTotalAmountAndFrequentFliersPoints(9d, 2);
	}

	@Test
	public void totalsFor_DualNewReleaseStatement () {
		statement.addRental (new Rental (aNewReleaseMovie(), 3));
		statement.addRental (new Rental (aNewReleaseMovie(), 3));

		statement.create();

		assertTotalAmountAndFrequentFliersPoints(18d, 4);
	}

	@Test
	public void totalsFor_SingleChildrensStatement () {
		statement.addRental (new Rental (aChildrenMovie(), 3));
		statement.create();

		assertTotalAmountAndFrequentFliersPoints(1.5, 1);
	}

	@Test
	public void outputFor_MultipleRegularStatement () {
		statement.addRental (new Rental (aRegularMovie("Plan 9 from Outer Space"), 1));
		statement.addRental (new Rental (aRegularMovie("8 1/2"), 2));
		statement.addRental (new Rental (aRegularMovie("Eraserhead"), 3));

		Assert.assertThat(statement.create(),is("Rental Record for Fred\n" +
			"\tPlan 9 from Outer Space\t2.0\n" +
			"\t8 1/2\t2.0\n" +
			"\tEraserhead\t3.5\n" +
			"You owed 7.5\n" +
			"You earned 3 frequent renter points\n") );
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