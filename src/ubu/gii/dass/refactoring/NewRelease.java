package ubu.gii.dass.refactoring;

public class NewRelease extends Price {

	double getCharge(Rental rental){
		return rental.getDaysRented() * 3;
	}
	
	public int getFrecuentRenterPoints(Rental rental) {
        if (rental.getDaysRented() > 1) return 2;
        return 1;
    }
	
}
