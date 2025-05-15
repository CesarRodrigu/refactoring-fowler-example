package ubu.gii.dass.refactoring;

public class Regular extends Price {

	int getPriceCode() {
		return Movie.REGULAR;	
	}
	
	public double getCharge(Rental rental) {
        double amount = 2;
        if (rental.getDaysRented() > 2)
            amount += (rental.getDaysRented() - 2) * 1.5;
        return amount;
    }
	
}
