package gal.udc.fic.vvs.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Cabecera;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * Fichero que contiene los tests de unidad de la clase "Cabecera"
 * 
 * @author dcode
 */
@RunWith(JUnitQuickcheck.class)
public class Cabecera_properties {
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención y
	 * establecimiento de los leidos
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una cabecera con la que se realizan las pruebas
	 * (estos datos los determinará la generación automaticade datos) 
	 */
	@Property
	public void testEstablecerLeidosYObtenerNoLeidos(@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String contenido, @From(StringGenerator.class) String valor) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		cabecera.establecerLeido(true);
		
		assertEquals(0, cabecera.obtenerNoLeidos());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del tamaño
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una cabecera con la que se realizan las pruebas
	 * (estos datos los determinará la generación automaticade datos) 
	 */
	@Property
	public void testObtenerTamaño(@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String contenido, @From(StringGenerator.class) String valor) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		assertEquals(mensaje.obtenerTamaño() + nombre.length() + valor.length(), 
				cabecera.obtenerTamaño());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del icono
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * del cuál se crea una cabecera con la que se realizan las pruebas
	 * (estos datos los determinará la generación automaticade datos) 
	 */
	@Property
	public void testObtenerIcono(@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String contenido, @From(StringGenerator.class) String valor) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, valor);
		
		int icono = cabecera.obtenerIcono();
		
		assertEquals(3, icono);
	}
}
