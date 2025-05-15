package ubu.gii.dass.refactoring;

public abstract class Price {

	abstract int getPriceCode();

	abstract double getCharge(Rental rental);

	public int getFrecuentRenterPoints(Rental rental) {
		// add bonus for a two day new release rental
		if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
			return 2;
		return 1;
	}
	
}
