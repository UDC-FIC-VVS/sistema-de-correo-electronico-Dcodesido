package gal.udc.fic.vvs.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Log;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * Fichero que contiene los tests de unidad de la clase "Log"
 * 
 * @author dcode
 */
@RunWith(JUnitQuickcheck.class)
public class Log_properties {

	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que que a traves de PBT
	 * prueba la obtencion del nombre
	 * Método de seleccion de datos: Un log
	 * que tenga un archivador simple con un nombre
	 * y espacio (obtenidos a través de generación automatica de datos) 
	 * para poder realizar la prueba
	 */
	@Property
	public void testObtenerNombre(@From(StringGenerator.class) String nombre,
			@InRange(min = "1") int espacio) {
		ArchivadorSimple decorado = new ArchivadorSimple(nombre, espacio);
		Log log = new Log(decorado);
		
		assertEquals(nombre,log.obtenerNombre());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que que a traves de PBT
	 * prueba a almacenar correo cuando el espacio
	 * no es el suficiente
	 * Método de seleccion de datos: Un mensaje con texto, y un log
	 * que tenga un archivador simple con un nombre
	 * y espacio determinados para poder realizar la prueba,
	 * siendo el espacio del archivador lo suficientemente bajo.
	 */
	@Property
	public void testAlmacenarCorreo(@From(StringGenerator.class) String nombre,
			@InRange(min = "1") int espacio) {
		ArchivadorSimple decorado = new ArchivadorSimple(nombre, espacio);
		Log log = new Log(decorado);
		Texto texto = new Texto("texto","...");
		Mensaje msg = new Mensaje(texto);
		
		log.establecerDelegado(log);
		assertTrue(log.almacenarCorreo(msg));
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del 
	 * espacio total
	 * Método de seleccion de datos: Un mensaje con texto, y un log
	 * que tenga un archivador simple con un nombre
	 * y espacio (obtenidos a través de generación automatica de datos) 
	 * para poder realizar la prueba
	 */
	@Property
	public void testObtenerEspacioTotal(@From(StringGenerator.class) String nombre,
			@InRange(min = "1") int espacio) {
		ArchivadorSimple decorado = new ArchivadorSimple(nombre, espacio);
		Log log = new Log(decorado);
		
		assertEquals(espacio, log.obtenerEspacioDisponible());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del 
	 * espacio disponible
	 * Método de seleccion de datos: Un mensaje con texto, y un log
	 * que tenga un archivador simple con un nombre
	 * y espacio (obtenidos a través de generación automatica de datos) 
	 * para poder realizar la prueba
	 */
	@Property
	public void testObtenerEspacioDisponible(@From(StringGenerator.class) String nombre,
			@InRange(min = "1") int espacio) {
		ArchivadorSimple decorado = new ArchivadorSimple(nombre, espacio);
		Log log = new Log(decorado);
		
		assertEquals(espacio, log.obtenerEspacioDisponible());
	}
}
