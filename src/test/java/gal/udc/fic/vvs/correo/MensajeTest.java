package gal.udc.fic.vvs.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

/**
 * Fichero que contiene los tests de unidad de la clase "Mensaje"
 * 
 * @author dcode
 */
public class MensajeTest {
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la establecimiento de leídos
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * con el que se realizan las pruebas
	 */
	@Test
	public void testEstablecerLeidosYObtenerLeidos() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
	    Mensaje mensaje = new Mensaje(texto);

	    mensaje.establecerLeido(true);
		
		assertEquals(0, mensaje.obtenerNoLeidos());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del tamaño
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * con el que se realizan las pruebas
	 */
	@Test
	public void testObtenerTamaño() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
	    Mensaje mensaje = new Mensaje(texto);

	    assertEquals(3, mensaje.obtenerTamaño());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del icono
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * con el que se realizan las pruebas
	 */
	@Test
	public void testObtenerIcono() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
	    Mensaje mensaje = new Mensaje(texto);
	    
	    int icono = mensaje.obtenerIcono();
		
		assertEquals(3, icono);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del icono
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * el cual se ha leido previamente con el que se realizan las pruebas
	 */
	@Test
	public void testObtenerIconoLeido() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
	    Mensaje mensaje = new Mensaje(texto);
	    
	    mensaje.establecerLeido(true);	    
	    int icono = mensaje.obtenerIcono();
		
		assertEquals(2, icono);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención de la previsualización
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * con el que se realizan las pruebas
	 */
	@Test
	public void testObtenerPreVisualizacion() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		String expected = "......";
		
		assertEquals(expected, mensaje.obtenerPreVisualizacion());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención de la visualización
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * con el que se realizan las pruebas
	 */
	@Test
	public void testObtenerVisualizacion() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		String expected = "...";
		
		assertEquals(expected, mensaje.obtenerVisualizacion());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función buscar()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * con el que se realizan las pruebas
	 */
	@Test
	public void testBuscar() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		Boolean result = (mensaje.buscar("...").toArray()[0]) == mensaje;

		assertEquals(true, result);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función buscar()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * con el que se realizan las pruebas. El string que se le pasa a buscar
	 * no corresponderá con el que compone su contenido
	 */
	@Test
	public void testBuscarContenidoNoExistente() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		Boolean result = mensaje.buscar("acdscws").isEmpty();

		assertEquals(true, result);
	}

}
