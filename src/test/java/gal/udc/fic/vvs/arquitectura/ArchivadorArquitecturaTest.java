package gal.udc.fic.vvs.arquitectura;

import org.junit.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

/**
 * Fichero que contiene los tests que prueban la arquitectura del paquete "Archivador"
 * 
 * @author dcode
 */
public class ArchivadorArquitecturaTest {
	
	private JavaClasses clases = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.correo");
	private JavaClasses metodos = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.correo");
	
	/**
	 * Tipo de test: Funcional dinámico estructural de caja blanca
	 * Descripción: Prueba que todas las clases dentro del paquete son publicas
	 */
	@Test
	public void testClasesPublicas() {
		
		ArchRule regla = classes().that().resideInAPackage("..archivador..").should().bePublic();
		
		regla.check(clases);
	}
	
	/**
	 * Tipo de test: Funcional dinámico estructural de caja blanca
	 * Descripción: Prueba que todos los metodos dentro del paquete son publicos
	 */
	@Test
	public void testMetodosPublicos() {

		ArchRule regla = methods().that().areDeclaredIn("..archivador..").should().bePublic();
		
		regla.check(metodos);
	}
	
	/**
	 * Tipo de test: Funcional dinámico estructural de caja blanca
	 * Descripción: Prueba que todos los metodos que contienen la palbra clave 
	 * "Nombre" dentro del paquete deben devolver un String
	 */
	@Test
    public void testObtenerNombreDebeDevolverString() { 
    	ArchRule regla = methods().that().haveNameMatching(".*Nombre").should().haveRawReturnType("String");
    	
    	regla.check(metodos);
	}
	
	/**
	 * Tipo de test: Funcional dinámico estructural de caja blanca
	 * Descripción: Prueba que todos los metodos que contienen la palbra clave 
	 * "Tamaño" dentro del paquete deben devolver un int
	 */
	@Test
    public void testObtenerTamañoDebeDevolverString() { 
    	ArchRule regla = methods().that().haveNameMatching(".*Tamaño").should().haveRawReturnType("int");
    	
    	regla.check(metodos);
	}
}
