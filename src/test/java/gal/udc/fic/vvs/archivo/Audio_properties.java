package gal.udc.fic.vvs.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Audio;

/**
 * Fichero que contiene los tests de unidad de la clase "Audio"
 * 
 * @author dcode
 */
@RunWith(JUnitQuickcheck.class)
public class Audio_properties {
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del nombre
	 * Método de seleccion de datos: Un audio con nombre y contenido (obtenidos a través
	 * de generación automatica de datos) para poder realizar la prueba
	 */
	@Property
	public void testObtenerNombre(@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String contenido) {
		
		Audio audio = new Audio(nombre, contenido);
		
		assertEquals(nombre, audio.obtenerNombre());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del contenido
	 * Método de seleccion de datos: Un audio con nombre y contenido (obtenidos a través
	 * de generación automatica de datos) para poder realizar la prueba
	 */
	@Property
	public void testObtenerContenido(@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String contenido) {
		
		Audio audio = new Audio(nombre, contenido);
		
		assertEquals(contenido, audio.obtenerContenido());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que a traves de PBT prueba la 
	 * obtención del tamaño de un audio 
	 * Método de seleccion de datos: Un audio con nombre y contenido (obtenidos a través
	 * de generación automatica de datos) para poder realizar la prueba
	 */
	@Property
	public void testObtenerTamaño(@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String contenido) {
		
		Audio audio = new Audio(nombre, contenido);
		
		assertEquals(contenido.length(), audio.obtenerTamaño());
	}

}
