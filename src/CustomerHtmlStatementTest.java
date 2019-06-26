import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerHtmlStatementTest {
	@Test
	public void oneCustomerOneRentalOneDayRegular() {
		Movie movie1 = new Movie("Terminator", Movie.REGULAR);
		Rental rental1 = new Rental(movie1, 1);
		Customer customer1 = new Customer("Sergey Muratov");
		customer1.addRental(rental1);
		assertEquals("<H1>Rentals for <EM>Sergey Muratov</EM></H1><P>\nTerminator: 2.0<BR>\n<P>You owe <EM>2.0</EM><P>\nOn this rental you earned <EM>1</EM> frequent renter points<P>", customer1.htmlStatement());
	}
	
	@Test
	public void oneCustomerOneRentalOneDayNewRelease() {
		Movie movie1 = new Movie("ABC", Movie.NEW_RELEASE);
		Rental rental1 = new Rental(movie1, 1);
		Customer customer1 = new Customer("Pavel Durov");
		customer1.addRental(rental1);
		assertEquals("<H1>Rentals for <EM>Pavel Durov</EM></H1><P>\nABC: 3.0<BR>\n<P>You owe <EM>3.0</EM><P>\nOn this rental you earned <EM>1</EM> frequent renter points<P>", customer1.htmlStatement());
	}
	
	@Test
	public void oneCustomerOneRentalThreeDaysRegular() {
		Movie movie1 = new Movie("DBMS", Movie.REGULAR);
		Rental rental1 = new Rental(movie1, 3);
		Customer customer1 = new Customer("Alexander Chapligin");
		customer1.addRental(rental1);
		assertEquals("<H1>Rentals for <EM>Alexander Chapligin</EM></H1><P>\nDBMS: 3.5<BR>\n<P>You owe <EM>3.5</EM><P>\nOn this rental you earned <EM>1</EM> frequent renter points<P>", customer1.htmlStatement());
	}
	
	@Test
	public void oneCustomerOneRentalTwoDaysNewRelease() {
		Movie movie1 = new Movie("ABCD", Movie.NEW_RELEASE);
		Rental rental1 = new Rental(movie1, 2);
		Customer customer1 = new Customer("Andrey Karpov");
		customer1.addRental(rental1);
		assertEquals("<H1>Rentals for <EM>Andrey Karpov</EM></H1><P>\nABCD: 6.0<BR>\n<P>You owe <EM>6.0</EM><P>\nOn this rental you earned <EM>2</EM> frequent renter points<P>", customer1.htmlStatement());
	}
}
