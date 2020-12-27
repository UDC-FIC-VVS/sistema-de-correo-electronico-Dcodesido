package gal.udc.fic.vvs.archivador;

import static org.junit.Assert.assertTrue;

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
	 * Descripción: Test de unidad que prueba a almacenar correo cuando el espacio
	 * es el suficiente 
	 * Método de seleccion de datos: Los adecuados para poder realizar la prueba,
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
	 * Método de seleccion de datos: Los adecuados para poder realizar la prueba,
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
}
