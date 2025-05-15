package ubu.gii.dass.refactoring;

import src.ubu.gii.dass.refactoring.Rental;

/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	Price _price;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPriceCode(int arg) {
		switch(arg) {
			case Movie.REGULAR:
				_price = new Regular();
				break;
			case Movie.NEW_RELEASE:
				_price = new NewRelease();
				break;
			case Movie.CHILDRENS:
				_price = new Children();
				break;
			default:
				throw new IllegalArgumentException("Código de precio incorrecto");
		}
	}

	public String getTitle() {
		return _title;
	}
	
	public double getCharge(Rental rental) {
		return _price.getCharge(rental);
	}

	public int getFrecuentRenterPoints(Rental rental) {
		// add bonus for a two day new release rental
		if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
			return 2;
		return 1;
	}
}
