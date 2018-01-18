package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomersTest {

	protected Customers customer;
	protected Movie m1, m2, m3;
	protected Rental r1, r2, r3;

	@Before
	public void setUp() throws Exception {
		m1 = new Movie("Rogue One", Movie.NEW_RELEASE);
		m2 = new Movie("Reine des neiges", Movie.CHILDRENS);
		m3 = new Movie("Star Wars III", Movie.REGULAR);

		r1 = new Rental(m1, 5);
		r2 = new Rental(m2, 7);
		r3 = new Rental(m3, 4);

		customer = new Customers("Charlie");
		customer.addRental(r1);
		customer.addRental(r2);
		customer.addRental(r3);
	}

	@After
	public void tearDown() throws Exception {
		m1 = m2 = m3 = null;
		r1 = r2 = r3 = null;
		customer = null;
	}

	@Test
	public void testStatement() {

		StringBuffer buffer = new StringBuffer();
		buffer.append("Rental Record for Charlie\n" + "	Rogue One	15.0 \n" + "	Reine des neiges	7.5 \n"
				+ "	Star Wars III	5.0 \n" + "Amount owned is 27.5\n" + "You earned 4 frequent renter points");
		assertEquals(buffer.toString(), customer.statement());

	}

}
