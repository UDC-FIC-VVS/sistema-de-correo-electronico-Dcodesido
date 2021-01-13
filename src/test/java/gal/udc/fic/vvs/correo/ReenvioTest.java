package gal.udc.fic.vvs.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;
import gal.udc.fic.vvs.email.correo.Reenvio;

/**
 * Fichero que contiene los tests de unidad de la clase "Reenvio"
 * 
 * @author dcode
 */
public class ReenvioTest {
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la establecimiento de leídos
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * con el que se realizan las pruebas
	 */
	@Test
	public void testEstablecerLeidosYObtenerLeidos() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
	    Mensaje mensajeAbs = new Mensaje(texto);
	    Mensaje mensaje = new Mensaje(texto);
	    Reenvio reenvio = new Reenvio(mensajeAbs, mensaje);

	    reenvio.establecerLeido(true);
		
		assertEquals(0, reenvio.obtenerNoLeidos());
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
	    Mensaje mensajeAbs = new Mensaje(texto);
	    Mensaje mensaje = new Mensaje(texto);
	    Reenvio reenvio = new Reenvio(mensajeAbs, mensaje);

	    assertEquals(mensajeAbs.obtenerTamaño()+mensaje.obtenerTamaño(), 
	    		reenvio.obtenerTamaño());
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
	    Mensaje mensajeAbs = new Mensaje(texto);
	    Mensaje mensaje = new Mensaje(texto);
	    Reenvio reenvio = new Reenvio(mensajeAbs, mensaje);
	    
	    int icono = reenvio.obtenerIcono();
		
		assertEquals(3, icono);
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
	    Mensaje mensajeAbs = new Mensaje(texto);
	    Mensaje mensaje = new Mensaje(texto);
	    Reenvio reenvio = new Reenvio(mensajeAbs, mensaje);
		
		String expected = "......";
		
		assertEquals(expected, reenvio.obtenerPreVisualizacion());
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
	    Mensaje mensajeAbs = new Mensaje(texto);
	    Mensaje mensaje = new Mensaje(texto);
	    Reenvio reenvio = new Reenvio(mensajeAbs, mensaje);
	    
		String expected = "...\n\n---- Correo reenviado ----\n\n...\n---- Fin correo reenviado ----";
		
		assertEquals(expected, reenvio.obtenerVisualizacion());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función explorar()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * con el que se realizan las pruebas
	 */
	@Test(expected = OperacionInvalida.class)
	public void testExplorar() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
	    Mensaje mensajeAbs = new Mensaje(texto);
	    Mensaje mensaje = new Mensaje(texto);
		Reenvio reenvio = new Reenvio(mensajeAbs, mensaje);
	    Carpeta carpeta = new Carpeta("nombre");

	    carpeta.añadir(reenvio);

	    reenvio.explorar();
	}
	
}
