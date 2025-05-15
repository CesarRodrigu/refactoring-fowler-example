package ubu.gii.dass.refactoring;
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
public class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		setMovie(movie);
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public int getFrecuentRenterPoints() {
		// add bonus for a two day new release rental
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
			return 2;
		return 1;
	}

	Movie getMovie() {
		return _movie;
	}

	void setMovie(Movie _movie) {
		this._movie = _movie;
	}

}
