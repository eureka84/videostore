

import junit.framework.*;
import price.ChildrenPrice;
import price.NewReleasePrice;
import price.RegularPrice;

public class VideoStoreTest extends TestCase
{

	private final NewReleasePrice newReleasePrice = new NewReleasePrice();
	private final ChildrenPrice childrenPrice = new ChildrenPrice();
	private final RegularPrice regularPrice = new RegularPrice();

	public VideoStoreTest (String name) {
		super (name);
	}
	
	protected void setUp ()  {
		customer = new Customer ("Fred");
	}
	
	public void testSingleNewReleaseStatement () {
		customer.addRental (new Rental (new Movie ("The Cell", newReleasePrice), 3));
		assertEquals ("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", customer.statement ());
	}

	public void testDualNewReleaseStatement () {
		customer.addRental (new Rental (new Movie ("The Cell", newReleasePrice), 3));
		customer.addRental (new Rental (new Movie ("The Tigger Movie", newReleasePrice), 3));
		assertEquals ("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", customer.statement ());
	}

	public void testSingleChildrensStatement () {
		customer.addRental (new Rental (new Movie ("The Tigger Movie", childrenPrice), 3));
		assertEquals ("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", customer.statement ());
	}
	
	public void testMultipleRegularStatement () {
		customer.addRental (new Rental (new Movie ("Plan 9 from Outer Space", regularPrice), 1));
		customer.addRental (new Rental (new Movie ("8 1/2", regularPrice), 2));
		customer.addRental (new Rental (new Movie ("Eraserhead", regularPrice), 3));
		
		assertEquals ("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", customer.statement ());
	}
	public void testMultipleHtmlStatement () {
		customer.addRental (new Rental (new Movie ("Plan 9 from Outer Space", regularPrice), 1));
		customer.addRental (new Rental (new Movie ("8 1/2", regularPrice), 2));
		customer.addRental (new Rental (new Movie ("Eraserhead", regularPrice), 3));

		assertEquals ("Rental Record for Fred<br>\tPlan 9 from Outer Space\t2.0<br>\t8 1/2\t2.0<br>\tEraserhead\t3.5<br>You owed 7.5<br>You earned 3 frequent renter points<br>", customer.htmlStatement ());
	}

	private Customer customer;
}