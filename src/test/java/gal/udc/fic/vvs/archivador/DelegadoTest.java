package gal.udc.fic.vvs.archivador;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Delegado;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * Fichero que contiene los tests de unidad de la clase "Delegado"
 * 
 * @author dcode
 */
public class DelegadoTest {
	
	private Texto texto = new Texto("texto","...");
	private String nombreArchivador = "Archivador";
	private int espacio = 200;
	private int espacioMenor = 1;
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba a almacenar correo cuando el espacio
	 * es el suficiente 
	 * Método de seleccion de datos: Un mensaje con texto, y un delegado
	 * que tenga un archivador simple con un nombre
	 * y espacio determinados para poder realizar la prueba,
	 * siendo el espacio del archivador lo suficientemente alto.
	 */
	@Test
	public void testAlmacenarCorreo() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacio);
		Delegado delegado = new Delegado(archivador);
		Mensaje msg = new Mensaje(texto);
		delegado.establecerDelegado(archivador);
		assertTrue(delegado.almacenarCorreo(msg));
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba a almacenar correo cuando el espacio
	 * no es el suficiente
	 * Método de seleccion de datos: Un mensaje con texto, y un delegado
	 * que tenga un archivador simple con un nombre
	 * y espacio determinados para poder realizar la prueba,
	 * siendo el espacio del archivador lo suficientemente bajo.
	 */
	@Test
	public void testAlmacenarCorreoMenor() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioMenor);
		Delegado delegado = new Delegado(archivador);
		Mensaje msg = new Mensaje(texto);
		delegado.establecerDelegado(archivador);
		assertTrue(!delegado.almacenarCorreo(msg));
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que prueba tanto la obtención como el establecimiento del delegado
	 * Método de seleccion de datos: Un delegado que tenga un archivador simple con un nombre
	 * y espacio determinados para poder realizar la prueba
	 */
	@Test
	public void testObtenerEstablecerDelegado() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacio);
		Delegado delegado = new Delegado(archivador);
		delegado.establecerDelegado(archivador);
		assertTrue(delegado.obtenerDelegado() == archivador);
	}

}
