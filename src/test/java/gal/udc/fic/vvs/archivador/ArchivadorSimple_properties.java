package gal.udc.fic.vvs.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * Fichero que contiene los tests de unidad de la clase "ArchivadorSimple"
 * 
 * @author dcode
 */
@RunWith(JUnitQuickcheck.class)
public class ArchivadorSimple_properties {
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del nombre
	 * Método de seleccion de datos: Un archivador simple con un nombre (obtenido a través
	 * de generación automatica de datos) y espacio determinados para poder realizar la prueba
	 */
	@Property
	public void testObtenerNombre(@From(StringGenerator.class) String nombre) {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre, 1);
		
		assertEquals(nombre, archivador.obtenerNombre());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba el almacenamiento del 
	 * correo
	 * Método de seleccion de datos: Un mensaje con texto, y un delegado
	 * y un archivador simple con un nombre 
	 * y espacio (obtenido a través de generación automatica de datos) 
	 * determinados para poder realizar la prueba
	 */
	@Property
	public void testAlmacenarCorreo(@From(StringGenerator.class) String nombre, 
			@InRange(min = "1") int espacio) {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre, espacio);
		Texto texto = new Texto("texto","...");
		Mensaje msg = new Mensaje(texto);

		assertTrue(archivador.almacenarCorreo(msg));
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del 
	 * espacio total
	 * Método de seleccion de datos: Un archivador simple con un nombre
	 * y espacio determinados para poder realizar la prueba
	 */
	@Property
	public void testObtenerEspacioTotal(@From(StringGenerator.class) String nombre,
			@InRange(min = "1") int espacio) {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre, espacio);
		
		assertEquals(espacio, archivador.obtenerEspacioDisponible());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del 
	 * espacio disponible
	 * Método de seleccion de datos: Un archivador simple con un nombre
	 * y espacio (obtenido a través de generación automatica de datos) 
	 * determinados para poder realizar la prueba
	 */
	@Property
	public void testObtenerEspacioDisponible(@From(StringGenerator.class) String nombre,
			@InRange(min = "1") int espacio) {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre, espacio);
		
		assertEquals(espacio, archivador.obtenerEspacioDisponible());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba el establecimiento y 
	 * obtencion del delegado
	 * Método de seleccion de datos: Un archivador simple con un nombre
	 * y espacio (obtenido a través de generación automatica de datos) 
	 * determinados para poder realizar la prueba
	 */
	@Property
	public void testObtenerEstablecerDelegado(@From(StringGenerator.class) String nombre, 
			@InRange(min = "1") int espacio) {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre, espacio);
		ArchivadorSimple delegado = new ArchivadorSimple(nombre, espacio);
		
		archivador.establecerDelegado(delegado);
		
		assertNull(archivador.obtenerDelegado());
	}
}
