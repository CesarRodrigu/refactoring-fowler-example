package ubu.gii.dass.refactoring;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.1
 * 
 * 
 */
public class VideoClubTest {
	protected Movie m0, m11, m12, m2;
	protected Customer c1;

	@Before
	public void setUp() {
		m11 = new Movie("Sky Captain", new NewRelease());
		m12 = new Movie("Alejandro Magno", new NewRelease());
		m0 = new Movie("Accion Mutante", new Regular());
		m2 = new Movie("Hermano Oso", new Children());

		c1 = new Customer("Manuel");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAlquiler() {

		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m0, 1);
		Rental r3 = new Rental(m2, 10);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);

		String salida = c1.statement();
		
		String salidaEsperada = new String(
				"Rental Record for Manuel\n" + "\tSky Captain\t15.0\n" + "\tAccion Mutante\t2.0\n"
						+ "\tHermano Oso\t12.0\n" + "Amount owed is 29.0\n" + "You earned 4 frequent renter points");

		assertTrue("Calcula mal el alquiler", salidaEsperada.equals(salida));

	}

	@Test
	public void testAlquiler2() {

		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m0, 3);
		Rental r3 = new Rental(m2, 1);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);

		String salida = c1.statement();

		String salidaEsperada = new String(
				"Rental Record for Manuel\n" + "\tSky Captain\t15.0\n" + "\tAccion Mutante\t3.5\n"
						+ "\tHermano Oso\t1.5\n" + "Amount owed is 20.0\n" + "You earned 4 frequent renter points");

		assertTrue("Calcula mal el alquiler", salidaEsperada.equals(salida));

	}
	
	@Test
    public void testGenerateHtmlStatement() {

		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m0, 1);
		Rental r3 = new Rental(m2, 10);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);
		
		String html = c1.htmlStatement();
		
		String datosEsperados = "<H1>Rental Record for Manuel</H1>" +
	              "<H2>Sky Captain 15.0</H2>" +
	              "<H2>Accion Mutante 2.0</H2><H2>Hermano Oso 12.0</H2>" +
	              "<P>Amount owed is 29.0</P><P> You earned 4 frequent renter points </P>";

        assertTrue("El texto esperado no se encuentra en el HTML.", html.equals(datosEsperados));
    }

}
