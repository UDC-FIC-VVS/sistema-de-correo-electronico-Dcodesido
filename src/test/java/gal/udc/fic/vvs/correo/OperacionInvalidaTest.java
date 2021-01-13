package gal.udc.fic.vvs.correo;

import static org.junit.Assert.*;

import org.junit.Test;

import gal.udc.fic.vvs.email.correo.OperacionInvalida;

/**
 * Fichero que contiene los tests de unidad de la clase "OperacionInvalida"
 * 
 * @author dcode
 */
public class OperacionInvalidaTest {
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra 
	 * Descripción: Test de unidad que prueba la descripción de la excepcion
	 * Método de seleccion de datos: Una instanca de la excepción "OperacionInvalida"
	 * y un string para su descripción
	 */
	@Test
	public void testOperacionInvalida() {
		OperacionInvalida exception = new OperacionInvalida("descripcion");
		
		assertEquals("descripcion", exception.getMessage());
	}

}
