package gal.udc.fic.vvs.archivo;

import static org.junit.Assert.*;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Imagen;

/**
 * Fichero que contiene los tests de unidad de la clase "Iamgen"
 * 
 * @author dcode
 */
public class ImagenTest {

	private String nombre = "Imagen";
	private String contenido = "Contenido";
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del nombre de una imagen 
	 * Método de seleccion de datos: Una imagen con nombre y contenido para poder realizar
	 * la prueba
	 */
	@Test
	public void testObtenerNombre() {
		Imagen imagen = new Imagen(nombre, contenido);
		assertTrue(imagen.obtenerNombre() == nombre);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del contenido de una imagen  
	 * Método de seleccion de datos: Una imagen con nombre y contenido para poder realizar
	 * la prueba
	 */
	@Test
	public void testObtenerContenido() {
		Imagen imagen = new Imagen(nombre, contenido);
		assertTrue(imagen.obtenerContenido() == contenido);
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del tamaño de una imagen 
	 * Método de seleccion de datos: Una imagen con nombre y contenido para poder realizar
	 * la prueba
	 */
	@Test
	public void testObtenerTamano() {
		Imagen imagen = new Imagen(nombre, contenido);
		assertTrue(imagen.obtenerTamaño() == contenido.length());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención de la previsualización de una imagen 
	 * Método de seleccion de datos: Una imagen con nombre y contenido para poder realizar
	 * la prueba
	 */
	@Test
	public void testObtenerPrevisualizacion() {
		Imagen imagen = new Imagen(nombre, contenido);
		assertEquals(imagen.obtenerPreVisualizacion(),
				nombre + "(" + contenido.length() + " bytes, " + "image/png)");
	}
}
