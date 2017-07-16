import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class VideoStoreTest
{
	private Statement statement = new Statement("any");

	@Test
	public void freqFliersPointsFor_SingleNewReleaseStatement() {
		statement.addRental (new Rental (aNewReleaseMovie(), 3));
		statement.create();
		assertThat(statement.frequentFliersPoints(), is(2));
	}

	@Test
	public void freqFliersPointsFor_DualNewReleaseStatement () {
		statement.addRental (new Rental (aNewReleaseMovie(), 3));
		statement.addRental (new Rental (aNewReleaseMovie(), 3));

		statement.create();

		assertThat(statement.frequentFliersPoints(), is(4));
	}

	@Test
	public void freqFliersPointsFor_SingleChildrensStatement () {
		statement.addRental (new Rental (aChildrenMovie(), 3));
		statement.create();

		assertThat(statement.frequentFliersPoints(), is(1));
	}

	@Test
	public void outputFor_MultipleRegularStatement () {

		Statement statement = new Statement("Fred");
		statement.addRental (new Rental (aRegularMovie("Plan 9 from Outer Space"), 1));
		statement.addRental (new Rental (aRegularMovie("8 1/2"), 2));
		statement.addRental (new Rental (aRegularMovie("Eraserhead"), 3));

		assertThat(statement.create(),is("Rental Record for Fred\n" +
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

	private Movie aNewReleaseMovie()
	{
		return new Movie ("The Cell", Movie.NEW_RELEASE);
	}

	private Movie aChildrenMovie()
	{
		return new Movie ("The Tigger Movie", Movie.CHILDRENS);
	}
}