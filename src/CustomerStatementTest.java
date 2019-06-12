import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerStatementTest {
	@Test
	public void oneCustomerOneRentalOneDayRegular() {
		Movie movie1 = new Movie("Terminator", Movie.REGULAR);
		Rental rental1 = new Rental(movie1, 1);
		Customer customer1 = new Customer("Sergey Muratov");
		customer1.addRental(rental1);
		assertEquals("Rental Record for Sergey Muratov\n\tTerminator\t2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points", customer1.statement());
	}
	
	@Test
	public void oneCustomerOneRentalOneDayNewRelease() {
		Movie movie1 = new Movie("ABC", Movie.NEW_RELEASE);
		Rental rental1 = new Rental(movie1, 1);
		Customer customer1 = new Customer("Pavel Durov");
		customer1.addRental(rental1);
		assertEquals("Rental Record for Pavel Durov\n\tABC\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points", customer1.statement());
	}
	
	@Test
	public void oneCustomerOneRentalThreeDaysRegular() {
		Movie movie1 = new Movie("DBMS", Movie.REGULAR);
		Rental rental1 = new Rental(movie1, 3);
		Customer customer1 = new Customer("Alexander Chapligin");
		customer1.addRental(rental1);
		assertEquals("Rental Record for Alexander Chapligin\n\tDBMS\t3.5\nAmount owed is 3.5\nYou earned 1 frequent renter points", customer1.statement());
	}
	
	@Test
	public void oneCustomerOneRentalTwoDaysNewRelease() {
		Movie movie1 = new Movie("ABCD", Movie.NEW_RELEASE);
		Rental rental1 = new Rental(movie1, 2);
		Customer customer1 = new Customer("Andrey Karpov");
		customer1.addRental(rental1);
		assertEquals("Rental Record for Andrey Karpov\n\tABCD\t6.0\nAmount owed is 6.0\nYou earned 2 frequent renter points", customer1.statement());
	}
	
	@Test
	public void oneCustomerOneRentalOneDayChildrens() {
		Movie movie1 = new Movie("WALL-E", Movie.CHILDRENS);
		Rental rental1 = new Rental(movie1, 1);
		Customer customer1 = new Customer("Alexey Komarov");
		customer1.addRental(rental1);
		assertEquals("Rental Record for Alexey Komarov\n\tWALL-E\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points", customer1.statement());
	}
	
	@Test
	public void oneCustomerOneRentalFiveDaysChildrens() {
		Movie movie1 = new Movie("Ratatouille", Movie.CHILDRENS);
		Rental rental1 = new Rental(movie1, 5);
		Customer customer1 = new Customer("Olga Semerova");
		customer1.addRental(rental1);
		assertEquals("Rental Record for Olga Semerova\n\tRatatouille\t4.5\nAmount owed is 4.5\nYou earned 1 frequent renter points", customer1.statement());
	}
	
	@Test
	public void oneCustomerTwoRentals() {
		Movie movie1 = new Movie("Terminator", Movie.REGULAR);
		Rental rental1 = new Rental(movie1, 1);
		Movie movie2 = new Movie("ABC", Movie.NEW_RELEASE);
		Rental rental2 = new Rental(movie2, 1);
		Customer customer1 = new Customer("Sergey Muratov");
		customer1.addRental(rental1);
		customer1.addRental(rental2);
		assertEquals("Rental Record for Sergey Muratov\n\tTerminator\t2.0\n\tABC\t3.0\nAmount owed is 5.0\nYou earned 2 frequent renter points", customer1.statement());
	}
}
