package JUnit.Junit09_Geometria.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class GeometriaTest {
	Geometria geometria;

	@BeforeEach
	public void before() {
		geometria = new Geometria();
	}

	private static Stream<Integer> getConstructorOpciones() {
		return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
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

	@DisplayName("Area del trapecio")
	@ParameterizedTest(name = "{index} => a={0}, b={1}, z={2}")
    @CsvSource({
            "5, 2, 10",
            "10, 5, 3",
            "12, 15, 14",
            "-6, 4, 25",
            "15, -3, -10"
    })
	public void testAreaTrapecio(int a, int b, int h) {
		double resultado = geometria.areatrapecio(a, b, h);
		double esperado =Math.abs(((a+b)/2)*h);
		int z = 1;
		assertEquals(esperado, resultado, z);
	}

	@Test
	public void testGetId() {
		int resultado = geometria.getId();
		assertTrue(resultado > 0 && resultado < 10);
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 })
	public void testSetId(int id) {
		int resultado;
		geometria.setId(id);
		resultado = geometria.getId();
		assertTrue(id == resultado);
	}

	@Test
	public void testGetNom() {
		String resultado = geometria.getNom();
		int contador = 0;
		boolean find = false;
		do {
			find = geometria.figura(contador).compareToIgnoreCase(resultado) == 0;
			contador++;
		} while (contador < 9 && !find);
		assertTrue(find);
	}

	@ParameterizedTest
	@ValueSource(strings = { "cuadrado", "Pentagono", "Triangulo" })
	public void testSetNom(String nom) {
		String resultado;
		geometria.setNom(nom);
		resultado = geometria.getNom();
		assertTrue(nom.compareToIgnoreCase(resultado) == 0);
	}

	@Test
	public void testGetArea() {
		int resultado = geometria.getId();
		assertTrue(resultado > 0 && resultado < 10);
	}

	@ParameterizedTest
	@ValueSource(doubles = { 1, 2, 5, -20, -5 })
	public void testSetArea(double area) {
		double resultado;
		geometria.setArea(area);
		resultado = geometria.getArea();
		assertTrue(area == resultado);
	}

	@Test
	public void testToString() {
		assertTrue(geometria.toString() instanceof String);
	}

}
