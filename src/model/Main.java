package model;

public class Main {

	public static void main(String[] args) {
		Movie rogue = new Movie("Rogue One", Movie.NEW_RELEASE);
		Movie reine = new Movie("Reine des neiges", Movie.CHILDRENS);
		Movie star = new Movie("Star Wars III", Movie.REGULAR);

		Rental rental1 = new Rental(rogue, 5);
		Rental rental2 = new Rental(reine, 7);
		Rental rental3 = new Rental(star, 4);

		Customers customer = new Customers("Charlie");
		customer.addRental(rental1);
		customer.addRental(rental2);
		customer.addRental(rental3);

		System.out.println(customer.statement());
	}

}
