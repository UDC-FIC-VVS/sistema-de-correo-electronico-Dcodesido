package gal.udc.fic.vvs.archivo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Fichero que contiene los tests de unidad de la clase "Audio"
 * 
 * @author dcode
 */
public class TextoTest {

	private String nombre = "Texto";
	private String contenido = "Contenido";

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del nombre de un audio
	 * Método de seleccion de datos: Un texto con nombre y contenido para poder realizar
	 * la prueba
	 */
	@Test
	public void testObtenerNombre() {
		Texto texto = new Texto(nombre, contenido);
		assertTrue(texto.obtenerNombre() == nombre);
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del contenido de un audio 
	 * Método de seleccion de datos: Un texto con nombre y contenido para poder realizar
	 * la prueba
	 */
	@Test
	public void testObtenerContenido() {
		Texto texto = new Texto(nombre, contenido);
		assertTrue(texto.obtenerContenido() == contenido);
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del tamaño de un audio 
	 * Método de seleccion de datos: Un texto con nombre y contenido para poder realizar
	 * la prueba
	 */
	@Test
	public void testObtenerTamano() {
		Texto texto = new Texto(nombre, contenido);
		assertTrue(texto.obtenerTamaño() == contenido.length());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la previsualización de un audio 
	 * Método de seleccion de datos: Un texto con nombre y contenido para poder realizar
	 * la prueba
	 */
	@Test
	public void testObtenerPrevisualizacion() {
		Texto texto = new Texto(nombre, contenido);
		assertEquals(texto.obtenerPreVisualizacion(), nombre + "(" + contenido.length() + " bytes, " + "text/plain)");
	}
}

