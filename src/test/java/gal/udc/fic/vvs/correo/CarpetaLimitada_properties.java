package gal.udc.fic.vvs.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.CarpetaLimitada;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

/**
 * Fichero que contiene los tests de unidad de la clase "CarpetaLimitada"
 * 
 * @author dcode
 */
@RunWith(JUnitQuickcheck.class)
public class CarpetaLimitada_properties {
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención y
	 * establecimiento de los leidos
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * el cual se usa para añadir a una carpeta con la que se realizan las pruebas
	 * (estos datos los determinará la generación automaticade datos) 
	 */
	@Property
	public void testEstablecerLeidosYObtenerNoLeidos(@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String contenido, @InRange(min = "1") int tamaño) throws OperacionInvalida {
		
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		
		carpetaLim.añadir(mensaje);
		carpetaLim.establecerLeido(true);
		
		assertEquals(0, carpetaLim.obtenerNoLeidos());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del tamaño
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * el cual se usa para añadir a una carpeta con la que se realizan las pruebas
	 * (estos datos los determinará la generación automaticade datos) 
	 */
	@Property
	public void testObtenerTamaño(@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String contenido, @InRange(min = "1") int tamaño) throws OperacionInvalida {
		
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		
		carpetaLim.añadir(mensaje);
		
		assertEquals(mensaje.obtenerTamaño(), carpetaLim.obtenerTamaño());
	}
	
	/**
	 * Tipo de test: Funcional dinámico de caja negra
	 * Descripción: Test de unidad que a traves de PBT prueba la obtención del icono
	 * Método de seleccion de datos: Un mensaje compuesto por un texto a través
	 * el cual se usa para añadir a una carpeta con la que se realizan las pruebas
	 * (estos datos los determinará la generación automaticade datos) 
	 */
	@Property
	public void testObtenerIcono(@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String contenido, @InRange(min = "1") int tamaño) throws OperacionInvalida {
		
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		CarpetaLimitada carpetaLim = new CarpetaLimitada(carpeta, tamaño);
		
		carpetaLim.añadir(mensaje);
	    int icono = carpetaLim.obtenerIcono();
		
		assertEquals(1, icono);
	}
}
