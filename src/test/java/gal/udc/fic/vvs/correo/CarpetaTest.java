package gal.udc.fic.vvs.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

/**
 * Fichero que contiene los tests de unidad de la clase "Carpeta"
 * 
 * @author dcode
 */
public class CarpetaTest {

	private String nombre = "nombre";
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la establecimiento de leídos
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */

	@Test
	public void testEstablecerLeidosYObtenerLeidos() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
	    Mensaje mensaje = new Mensaje(texto);

	    carpeta.añadir(mensaje);
		carpeta.establecerLeido(true);
		
		assertEquals(0, carpeta.obtenerNoLeidos());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del tamaño
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * ademas de crear una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerTamaño() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
	    Mensaje mensaje = new Mensaje(texto);

	    carpeta.añadir(mensaje);
	    
	    assertEquals(mensaje.obtenerTamaño(), carpeta.obtenerTamaño());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del icono
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * ademas de crear una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerIcono() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
	    Mensaje mensaje = new Mensaje(texto);
	    
	    carpeta.añadir(mensaje);
	    int icono = carpeta.obtenerIcono();
		
		assertEquals(1, icono);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención de la previsualización
	 * cuando una carpeta no se ha leído
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerPreVisualizacion() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpeta.añadir(mensaje);
		String expected = "nombre (1)";
		
		assertEquals(expected, carpeta.obtenerPreVisualizacion());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención de la previsualización
	 * cuando una carpeta se ha leído
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerPreVisualizacionNoLeidos() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpeta.añadir(mensaje);
		carpeta.establecerLeido(true);
		String expected = "nombre";
		
		assertEquals(expected, carpeta.obtenerPreVisualizacion());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención de la visualización
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerVisualizacion() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpeta.añadir(mensaje);
		String expected = "nombre (1)";
		
		assertEquals(expected, carpeta.obtenerVisualizacion());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función obtenerRuta()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crean dos carpetas con las que se realizan las pruebas
	 */
	@Test
	  public void obtenerRuta() throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombre);
		Carpeta carpetaAux = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaAux.añadir(mensaje);
		carpeta.añadir(carpetaAux);
		
		String expected = "nombre (1) > nombre (1)";

	    assertEquals(expected, carpetaAux.obtenerRuta());
	  }

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función explorar()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testExplorar() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpeta.añadir(mensaje);
		Boolean result = (carpeta.explorar().toArray()[0]) == mensaje;
		
		assertEquals(true, result);
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función buscar()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testBuscar() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpeta.añadir(mensaje);
		Boolean result = (carpeta.buscar("...").toArray()[0]) == mensaje;

		assertEquals(true, result);
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función añadir()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto cada uno a través
	 * del cuál se crean dos carpetas con las que se realizan las pruebas
	 */
	@Test
	public void testAñadir() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Carpeta carpetaAux = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaAux.añadir(mensaje);
		carpeta.añadir(carpetaAux);
		
		assertEquals(carpeta.obtenerTamaño(), mensaje.obtenerTamaño());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función añadir()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto cada uno a través
	 * del cuál se crean dos carpetas con las que se realizan las pruebas
	 */
	@Test
	public void testAñadirCorreoConPadre() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Carpeta carpetaAux = new Carpeta(nombre);
		Carpeta carpetaAux2 = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaAux.añadir(mensaje);
		carpeta.añadir(carpetaAux);
		carpetaAux2.añadir(carpetaAux);
		
		assertNull(carpetaAux2.obtenerPadre());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función eliminar()
	 * Método de seleccion de datos: Dos mensajes compuesto por un texto cada uno a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testEliminar() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Mensaje mensajeAux = new Mensaje(texto);
		
		carpeta.añadir(mensaje);
	    carpeta.añadir(mensajeAux);

	    carpeta.eliminar(mensajeAux);
	    Boolean result = (carpeta.explorar().toArray()[0]) == mensajeAux;
	    
	    assertEquals(false, result);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función obtenerHijo()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se espera recuperar una excepción
	 */
	@Test
	public void testObtenerHijo() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Carpeta carpetaAux = new Carpeta(nombre);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaAux.añadir(mensaje);
		carpeta.añadir(carpetaAux);
		
		assertEquals(carpeta.obtenerTamaño(), mensaje.obtenerTamaño());
	}
	

}
