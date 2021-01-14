package gal.udc.fic.vvs.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Adjunto;
import gal.udc.fic.vvs.email.correo.Cabecera;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

/**
 * Fichero que contiene los tests de unidad de la clase "Adjunto"
 * 
 * @author dcode
 */
public class AdjuntoTest {
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba el establecimiento de leídos
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea un adjunto con el que se realizan las pruebas
	 */
	@Test
	public void testEstablecerLeidosYObtenerNoLeidos() throws OperacionInvalida {
		
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		
		adjunto.establecerLeido(true);
		
		assertEquals(0, adjunto.obtenerNoLeidos());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del tamaño
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea un adjunto con el que se realizan las pruebas
	 */
	@Test
	public void testObtenerTamaño() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		
		assertEquals(texto.obtenerTamaño() + mensaje.obtenerTamaño(), adjunto.obtenerTamaño());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del icono
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea un adjunto con el que se realizan las pruebas
	 */
	@Test
	public void testObtenerIcono() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		
		int icono = adjunto.obtenerIcono();
		
		assertEquals(3, icono);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención de la previsualización
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea un adjunto con el que se realizan las pruebas
	 */
	@Test
	public void testObtenerPreVisualizacion() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		
		String expected = "......";
		
		assertEquals(expected, adjunto.obtenerPreVisualizacion());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención de la visualización
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea un adjunto con el que se realizan las pruebas
	 */
	@Test
	public void testObtenerVisualizacion() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		
		String expected = "...\n\nAdxunto: texto(3 bytes, text/plain)";
		
		assertEquals(expected, adjunto.obtenerVisualizacion());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función explorar()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea un adjunto con el que se espera que devuelva una excepción.
	 */
	@Test
	public void testExplorarException() {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		
		Assert.assertThrows(OperacionInvalida.class, () -> adjunto.explorar());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función buscar()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea un adjunto con el que se realizan las pruebas
	 */
	@Test
	public void testBuscar() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		
		Adjunto expected = (Adjunto) adjunto.buscar("...").toArray()[0];
		
		assertEquals(expected, adjunto);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función obtenerRuta()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea un adjunto con el que se realizan las pruebas
	 */
	@Test
	public void testObtenerRuta() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		
		String expected = "......";
		
		assertEquals(expected, adjunto.obtenerRuta());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función añadir()
	 * Método de seleccion de datos: Dos mensajes compuesto por un texto cada uno a través
	 * del cuál se crea un adjunto con el que se espera recuperar una excepción
	 */
	@Test
	public void testAñadirException(){
		Texto texto = new Texto("texto", "...");
		
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		
		Mensaje mensajeAux = new Mensaje(texto);
		Cabecera adjuntoAux = new Cabecera(mensajeAux, "nombre", "valor");
		
		Assert.assertThrows(OperacionInvalida.class, () -> adjunto.añadir(adjuntoAux));
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función obtenerHijo()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea un adjunto con el que se espera recuperar una excepción
	 */
	@Test
	public void testObtenerHijoException() {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		
		Assert.assertThrows(OperacionInvalida.class, () -> adjunto.obtenerHijo(0));
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función obtenerPadre()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea un adjunto con el que se realizan las pruebas
	 */
	@Test
	public void testObtenerPadre() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		
		assertEquals(null, adjunto.obtenerPadre());
	}

}
