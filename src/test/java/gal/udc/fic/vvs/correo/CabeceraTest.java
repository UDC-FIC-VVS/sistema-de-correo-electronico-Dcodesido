package gal.udc.fic.vvs.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Cabecera;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

/**
 * Fichero que contiene los tests de unidad de la clase "Cabecera"
 * 
 * @author dcode
 */
public class CabeceraTest {
	
	private String nombre = "nombre";
	private String valor = "valor";
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la establecimiento de leídos
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una cabecera con la que se realizan las pruebas
	 */

	@Test
	public void testEstablecerLeidosYObtenerLeidos() throws OperacionInvalida {
		
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		cabecera.establecerLeido(true);
		
		assertEquals(0, cabecera.obtenerNoLeidos());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del tamaño
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una cabecera con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerTamaño() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		assertEquals(14, cabecera.obtenerTamaño());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del icono
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea un cabecera con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerIcono() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		int icono = cabecera.obtenerIcono();
		
		assertEquals(3, icono);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención de la previsualización
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una cabecera con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerPreVisualizacion() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		String expected = "......";
		
		assertEquals(expected, cabecera.obtenerPreVisualizacion());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención de la visualización
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una cabecera con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerVisualizacion() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		String expected = "nombre: valor\n...";
		
		assertEquals(expected, cabecera.obtenerVisualizacion());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función explorar()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una cabecera con la que se espera que devuelva una excepción.
	 */
	@Test(expected = OperacionInvalida.class)
	public void testExplorarException() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		cabecera.explorar();
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función buscar()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una cabecera con la que se realizan las pruebas
	 */
	@Test
	public void testBuscar() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		Cabecera expected = (Cabecera) cabecera.buscar("...").toArray()[0];
		
		assertEquals(expected, cabecera);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función obtenerRuta()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una cabecera con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerRuta() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		String expected = "......";
		
		assertEquals(expected, cabecera.obtenerRuta());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función añadir()
	 * Método de seleccion de datos: Dos mensajes compuesto por un texto cada uno a través
	 * del cuál se crea una cabecera con la que se espera recuperar una excepción
	 */
	@Test(expected = OperacionInvalida.class)
	public void testAñadirException() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		Mensaje mensajeAux = new Mensaje(texto);
		Cabecera cabeceraAux = new Cabecera(mensajeAux, "nombre", "valor");
		
		cabecera.añadir(cabeceraAux);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función obtenerHijo()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una cabecera con la que se espera recuperar una excepción
	 */
	@Test(expected = OperacionInvalida.class)
	public void testObtenerHijoException() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		cabecera.obtenerHijo(0);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función obtenerPadre()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea un cabecera con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerPadre() throws OperacionInvalida {
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		assertEquals(null, cabecera.obtenerPadre());
	}
}
