package gal.udc.fic.vvs.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

/**
 * Fichero que contiene los tests de unidad de la clase "Mensaje"
 * 
 * @author dcode
 */
@RunWith(JUnitQuickcheck.class)
public class Mensaje_properties {

	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención y
	 * establecimiento de los leidos
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cual se realizan las pruebas
	 * (estos datos los determinará la generación automaticade datos) 
	 */
	@Property
	public void testEstablecerLeidosYObtenerNoLeidos(@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String contenido) throws OperacionInvalida {
		
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		
		mensaje.establecerLeido(true);
		
		assertEquals(0, mensaje.obtenerNoLeidos());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del tamaño
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cual se realizan las pruebas
	 * (estos datos los determinará la generación automaticade datos) 
	 */
	@Property
	public void testObtenerTamaño(@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String contenido) throws OperacionInvalida {
		
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		
		assertEquals(mensaje.obtenerTamaño(), mensaje.obtenerTamaño());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del icono
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cual se realizan las pruebas
	 * (estos datos los determinará la generación automaticade datos) 
	 */
	@Property
	public void testObtenerIcono(@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String contenido) throws OperacionInvalida {
		
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);

	    int icono = mensaje.obtenerIcono();
		
		assertEquals(3, icono);
	}
	
}
