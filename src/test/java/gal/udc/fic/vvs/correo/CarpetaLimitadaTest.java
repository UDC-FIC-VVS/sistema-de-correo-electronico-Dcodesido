package gal.udc.fic.vvs.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.CarpetaLimitada;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

/**
 * Fichero que contiene los tests de unidad de la clase "CarpetaLimitada"
 * 
 * @author dcode
 */
public class CarpetaLimitadaTest {
	
	private String nombre = "nombre";
	private int tamaño = 10;
	private Carpeta carpeta = new Carpeta(nombre);
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la establecimiento de leídos
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */

	@Test
	public void testEstablecerLeidosYObtenerLeidos() throws OperacionInvalida {
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		Texto texto = new Texto("texto", "...");
	    Mensaje mensaje = new Mensaje(texto);

	    carpetaLim.añadir(mensaje);
	    carpetaLim.establecerLeido(true);
		
		assertEquals(0, carpetaLim.obtenerNoLeidos());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del tamaño
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * ademas de crear una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerTamaño() throws OperacionInvalida {
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		Texto texto = new Texto("texto", "...");
	    Mensaje mensaje = new Mensaje(texto);

	    carpetaLim.añadir(mensaje);
	    
	    assertEquals(mensaje.obtenerTamaño(), carpetaLim.obtenerTamaño());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención del icono
	 * Método de seleccion de datos: Un mensaje compuesto por un texto
	 * ademas de crear una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerIcono() throws OperacionInvalida {
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		Texto texto = new Texto("texto", "...");
	    Mensaje mensaje = new Mensaje(texto);
	    
	    carpetaLim.añadir(mensaje);
	    int icono = carpetaLim.obtenerIcono();
		
		assertEquals(1, icono);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención de la previsualización
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerPreVisualizacion() throws OperacionInvalida {
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaLim.añadir(mensaje);
		String expected = "nombre (1)";
		
		assertEquals(expected, carpetaLim.obtenerPreVisualizacion());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la obtención de la visualización
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerVisualizacion() throws OperacionInvalida {
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaLim.añadir(mensaje);
		String expected = "nombre (1)";
		
		assertEquals(expected, carpetaLim.obtenerVisualizacion());
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función explorar()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testExplorar() throws OperacionInvalida {
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaLim.añadir(mensaje);
		Boolean result = (carpetaLim.explorar().toArray()[0]) == mensaje;
		
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
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaLim.añadir(mensaje);
		Boolean result = (carpetaLim.buscar("...").toArray()[0]) == mensaje;

		assertEquals(true, result);
	}

	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función añadir()
	 * Método de seleccion de datos: Dos mensajes compuesto por un texto cada uno a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testAñadir() throws OperacionInvalida {
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaLim.añadir(mensaje);
		
		assertEquals(carpetaLim.obtenerTamaño(), mensaje.obtenerTamaño());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función eliminar()
	 * Método de seleccion de datos: Dos mensajes compuesto por un texto cada uno a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testEliminar() throws OperacionInvalida {
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		Texto texto = new Texto("texto", "...");
		Mensaje mensaje = new Mensaje(texto);
		Mensaje mensajeAux = new Mensaje(texto);
		
		carpetaLim.añadir(mensaje);
		carpetaLim.añadir(mensajeAux);

		carpetaLim.eliminar(mensajeAux);
	    Boolean result = (carpetaLim.explorar().toArray()[0]) == mensajeAux;
	    
	    assertEquals(false, result);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función obtenerHijo()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerHijo() throws OperacionInvalida {
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		CarpetaLimitada carpetaLimAux = new CarpetaLimitada(carpeta, tamaño);
		
		carpetaLim.añadir(carpetaLimAux);
		
		Correo result = carpetaLim.obtenerHijo(0);
		
		assertEquals(result, carpetaLimAux);
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la función obtenerPadre()
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una carpeta con la que se realizan las pruebas
	 */
	@Test
	public void testObtenerPadre() throws OperacionInvalida {
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		CarpetaLimitada carpetaLimAux = new CarpetaLimitada(carpeta, tamaño);
		
		carpetaLim.añadir(carpetaLimAux);
		
		Correo result = carpetaLimAux.obtenerPadre();
		
		assertEquals(result, carpeta);
	}
}
