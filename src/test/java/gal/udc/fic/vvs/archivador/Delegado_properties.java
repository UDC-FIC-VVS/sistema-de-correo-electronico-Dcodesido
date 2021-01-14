package gal.udc.fic.vvs.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Delegado;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * Fichero que contiene los tests de unidad de la clase "Delegado"
 * 
 * @author dcode
 */
@RunWith(JUnitQuickcheck.class)
public class Delegado_properties {
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que que a traves de PBT
	 * prueba la obtencion del nombre
	 * Método de seleccion de datos: Un mensaje con texto, y un delegado
	 * que tenga un archivador simple con un nombre
	 * y espacio (obtenidos a través de generación automatica de datos) 
	 * para poder realizar la prueba
	 */
	@Property
	public void testObtenerNombre(@From(StringGenerator.class) String nombre) {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre, 1);
		Delegado delegado = new Delegado(archivador);
		
		assertEquals(nombre, delegado.obtenerNombre());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que que a traves de PBT prueba a 
	 * almacenar correo cuando el espacio
	 * Método de seleccion de datos: Un mensaje con texto, y un delegado
	 * que tenga un archivador simple con un nombre
	 * y espacio (obtenidos a través de generación automatica de datos) 
	 * para poder realizar la prueba
	 */
	@Property
	public void testAlmacenarCorreo(@From(StringGenerator.class) String nombre, 
			@InRange(min = "1") int espacio) {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre, espacio);
		Delegado delegado = new Delegado(archivador);
		Texto texto = new Texto("texto","...");
		Mensaje msg = new Mensaje(texto);
		
		delegado.establecerDelegado(archivador);
		assertTrue(delegado.almacenarCorreo(msg));
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT 
	 * prueba la obtención del espacio total
	 * Método de seleccion de datos: Un archivador simple con un nombre
	 * y espacio determinados para poder realizar la prueba
	 */
	@Property
	public void testObtenerEspacioTotal(@From(StringGenerator.class) String nombre,
			@InRange(min = "1") int espacio) {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre, espacio);
		Delegado delegado = new Delegado(archivador);
		
		assertEquals(espacio, delegado.obtenerEspacioDisponible());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT 
	 * prueba la obtención del espacio disponible
	 * Método de seleccion de datos: Un archivador simple con un nombre
	 * y espacio (obtenido a través de generación automatica de datos) 
	 * determinados para poder realizar la prueba
	 */
	@Property
	public void testObtenerEspacioDisponible(@From(StringGenerator.class) String nombre,
			@InRange(min = "1") int espacio) {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre, espacio);
		Delegado delegado = new Delegado(archivador);
		
		assertEquals(espacio, delegado.obtenerEspacioDisponible());
	}
	
	

}
