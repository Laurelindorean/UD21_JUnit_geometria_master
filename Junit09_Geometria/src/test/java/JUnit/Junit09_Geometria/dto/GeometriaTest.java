package JUnit.Junit09_Geometria.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import JUnit.Junit09_Geometria.dto.Geometria;

class GeometriaTest {
	Geometria geometria;
	@BeforeEach
	public void before() {
		geometria = new Geometria();
	}
	
	
	private static Stream<Integer> getConstructorOpciones(){
		return Stream.of(1,2,3,4,5,6,7,8,9);
	}
	@ParameterizedTest
	@MethodSource("getConstructorOpciones")
	public void testConstructorOpciones(int id) {
		geometria = new Geometria(id);
	}
	
	@Test
	public void testAreaCuadrado() {
		int resultado = geometria.areacuadrado(5);
		int esperado = 25;
		assertEquals(esperado, resultado);
	}
	@Test
	public void testAreaCirculo() {
		double resultado = geometria.areaCirculo(25);
		double esperado = 1963.5;
		assertEquals(esperado, resultado);
	}
	@Test
	public void testAreaTriangulo() {
		int resultado = geometria.areatriangulo(5, 8);
		int esperado = 20;
		assertEquals(esperado, resultado);
	}
	@Test
	public void testAreaRectangulo() {
		int resultado = geometria.arearectangulo(12, 18);
		int esperado = 216;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testAreaPentagono() {
		int resultado = geometria.areapentagono(10, 5);
		int esperado = 25;
		assertEquals(esperado, resultado);
	}
	@Test
	public void testAreaRombo() {
		int resultado = geometria.arearombo(5, 10);
		int esperado = 25;
		assertEquals(esperado, resultado);
	}
	@Test
	public void testAreaRomboide() {
		int resultado = geometria.arearomboide(5, 10);
		int esperado = 50;
		assertEquals(esperado, resultado);
	}
	@Test
	public void testAreaTrapecio() {
		int resultado = geometria.areatrapecio(5, 10, 7);
		int esperado = 49;
		assertEquals(esperado, resultado);
	}
	@Test
	public void testGetId() {
		int resultado = geometria.getId();
		assertTrue(resultado>0&& resultado<10);
	}
	@Test
	public void testSetId() {
		geometria.setId(2);
		assertTrue(geometria.getId()==2);
	}
	@Test
	public void testGetNom() {
		geometria.setNom("Cuadrado");
		assertTrue(geometria.getNom()=="Cuadrado");
	}
	@Test
	public void testSetNom() {
		geometria.setNom("Triangulo");
		assertTrue(geometria.getNom()=="Triangulo");
	}
	@Test
	public void testGetArea() {
		geometria.setArea(25.3);
		assertTrue(geometria.getArea()==25.3);
	}
	@Test
	public void testSetArea() {
		geometria.setArea(32.1);
		assertTrue(geometria.getArea()==32.1);
	}

	@Test
	public void testToString() {
		
	}

}
