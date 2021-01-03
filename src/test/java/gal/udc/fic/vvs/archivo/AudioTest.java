package gal.udc.fic.vvs.archivo;

import static org.junit.Assert.*;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Audio;

/**
 * Fichero que contiene los tests de unidad de la clase "Audio"
 * 
 * @author dcode
 */
public class AudioTest {

	private String nombre = "Audio";
	private String contenido = "Contenido";

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del nombre de un audio
	 * Método de seleccion de datos: Un audio con nombre y contenido para poder realizar
	 * la prueba
	 */
	@Test
	public void testObtenerNombre() {
		Audio audio = new Audio(nombre, contenido);
		assertTrue(audio.obtenerNombre() == nombre);
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del contenido de un audio 
	 * Método de seleccion de datos: Un audio con nombre y contenido para poder realizar
	 * la prueba
	 */
	@Test
	public void testObtenerContenido() {
		Audio audio = new Audio(nombre, contenido);
		assertTrue(audio.obtenerContenido() == contenido);
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del tamaño de un audio 
	 * Método de seleccion de datos: Un audio con nombre y contenido para poder realizar
	 * la prueba
	 */
	@Test
	public void testObtenerTamano() {
		Audio audio = new Audio(nombre, contenido);
		assertTrue(audio.obtenerTamaño() == contenido.length());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la previsualización de un audio 
	 * Método de seleccion de datos: Un audio con nombre y contenido para poder realizar
	 * la prueba
	 */
	@Test
	public void testObtenerPrevisualizacion() {
		Audio audio = new Audio(nombre, contenido);
		assertEquals(audio.obtenerPreVisualizacion(), nombre + "(" + contenido.length() + " bytes, " + "audio/ogg)");
	}
}
