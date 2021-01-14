package gal.udc.fic.vvs.archivador;

import static org.junit.Assert.*;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Log;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * Fichero que contiene los tests de unidad de la clase "Log"
 * 
 * @author dcode
 */
public class LogTest {
	
	private Texto texto = new Texto("texto","...");
	private String nombreArchivador = "Archivador";
	private int espacio = 200;
	private int espacioMenor = 1;
	
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba la obtencion del nombre del log 
	 * Método de seleccion de datos: un archivador y un log
	 */
	@Test
	public void testObtenerNombre() {
		ArchivadorSimple decorado = new ArchivadorSimple(nombreArchivador, espacio);
		Log log = new Log(decorado);
		
		assertEquals(nombreArchivador,log.obtenerNombre());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba a almacenar correo cuando el espacio
	 * es el suficiente 
	 * Método de seleccion de datos: Un mensaje con texto, y un log
	 * que tenga un archivador simple con un nombre
	 * y espacio determinados para poder realizar la prueba
	 * siendo el espacio del archivador lo suficientemente alto.
	 */
	@Test
	public void testAlmacenarCorreo() {
		ArchivadorSimple decorado = new ArchivadorSimple(nombreArchivador, espacio);
		Log log = new Log(decorado);
		Mensaje msg = new Mensaje(texto);
		log.establecerDelegado(log);
		assertTrue(log.almacenarCorreo(msg));
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba a almacenar correo cuando el espacio
	 * no es el suficiente
	 * Método de seleccion de datos: Un mensaje con texto, y un log
	 * que tenga un archivador simple con un nombre
	 * y espacio determinados para poder realizar la prueba,
	 * siendo el espacio del archivador lo suficientemente bajo.
	 */
	@Test
	public void testAlmacenarCorreoMenor() {
		ArchivadorSimple decorado = new ArchivadorSimple(nombreArchivador, espacioMenor);
		Log log = new Log(decorado);
		Mensaje msg = new Mensaje(texto);
		log.establecerDelegado(log);
		assertTrue(!log.almacenarCorreo(msg));
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba la obtencion del esppacio
	 * total
	 * Método de seleccion de datos: un archivador y un log
	 */
	@Test
	public void testObtenerEspacioTotal() {
		ArchivadorSimple decorado = new ArchivadorSimple(nombreArchivador, espacio);
		Log log = new Log(decorado);
		
		assertEquals(200,log.obtenerEspacioTotal());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba la obtencion del espacio
	 * disponible
	 * Método de seleccion de datos: un archivador y un log
	 */
	
	@Test
	public void testObtenerEspacioDisponible() {
		ArchivadorSimple decorado = new ArchivadorSimple(nombreArchivador, espacio);
		Log log = new Log(decorado);
		
		assertEquals(200,log.obtenerEspacioDisponible());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba la obtencion del delegado
	 * Método de seleccion de datos: un archivador y un log
	 */
	@Test
	public void testObtenerDelegado() {
		ArchivadorSimple decorado = new ArchivadorSimple(nombreArchivador, espacio);
		Log log = new Log(decorado);
		
		log.establecerDelegado(log);
		
		assertNull(log.obtenerDelegado());
	}
}
