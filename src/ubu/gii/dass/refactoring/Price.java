package ubu.gii.dass.refactoring;

public abstract class Price {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	abstract double getCharge(Rental rental);

	public int getFrecuentRenterPoints(Rental rental) {
		return 1;
	}
	
}
