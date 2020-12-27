package gal.udc.fic.vvs.archivador;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

 /**
  * Fichero que contiene los tests de unidad de la clase "ArchivadorSimple"
  * 
  * @author dcode
  */
public class ArchivadorSimpleTest {
	
	private Texto texto = new Texto("texto","...");
	private String nombreArchivador = "Archivador";
	private String nombreDelegado = "Delegado";
	private int espacio = 200;
	private int espacioMenor = 1;
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba la obtención del nombre
	 * Método de seleccion de datos: Los adecuados para poder realizar la prueba
	 */
	@Test
	public void testObtenerNombre() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacio);
		assertTrue(archivador.obtenerNombre() == nombreArchivador);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba a almacenar correo cuando el espacio
	 * es el suficiente 
	 * Método de seleccion de datos: Los adecuados para poder realizar la prueba,
	 * siendo el espacio del archivador lo suficientemente alto.
	 */
	@Test
	public void testAlmacenarCorreo() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacio);
		Mensaje msg = new Mensaje(texto);
		assertTrue(archivador.almacenarCorreo(msg));
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
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioMenor);
		Mensaje msg = new Mensaje(texto);
		assertTrue(!archivador.almacenarCorreo(msg));
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba la obtención del espacio total
	 * Método de seleccion de datos: Los adecuados para poder realizar la prueba
	 */
	@Test
	public void testObtenerEspacioTotal() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacio);
		assertTrue(archivador.obtenerEspacioDisponible() == espacio);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba la obtención del espacio disponible
	 * Método de seleccion de datos: Los adecuados para poder realizar la prueba
	 */
	@Test
	public void testObtenerEspacioDisponible() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacio);
		assertTrue(archivador.obtenerEspacioDisponible() == espacio);
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba tanto la obtención como el establecimiento del delegado
	 * Método de seleccion de datos: Los adecuados para poder realizar la prueba
	 */
	@Test
	public void testObtenerEstablecerDelegado() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacio);
		ArchivadorSimple delegado = new ArchivadorSimple(nombreDelegado, espacio);
		archivador.establecerDelegado(delegado);
		assertTrue(archivador.obtenerDelegado() == null);
	}
	
	
	
}
