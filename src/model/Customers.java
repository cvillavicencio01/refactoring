package model;

import java.util.*;

public class Customers {
	private String _name;
	private Vector _rentals = new Vector();

	public Customers(String name) {
		_name = name;
	}

	public void addRental(Rental rental) {
		_rentals.addElement(rental);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			frequentRenterPoints += each.getFrequentRenterPoints();
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + " \n";
		}
		result += "Amount owned is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;

	}

	private double getTotalCharge(){
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
}
