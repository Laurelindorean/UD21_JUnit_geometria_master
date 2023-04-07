package JUnit.Junit09_Geometria.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class GeometriaTest {
	Geometria geometria;

	@BeforeEach
	public void before() {
		geometria = new Geometria();
	}

	private static Stream<Arguments> getConstructorOpciones() {
		return Stream.of(Arguments.of(1, "cuadrado"), Arguments.of(2, "Circulo"), Arguments.of(3, "Triangulo"),
				Arguments.of(4, "Rectangulo"), Arguments.of(5, "Pentagono"), Arguments.of(6, "Rombo"),
				Arguments.of(7, "Romboide"), Arguments.of(8, "Trapecio"), Arguments.of(9, "Default"));
	}

	@ParameterizedTest
	@MethodSource("getConstructorOpciones")
	public void testConstructorOpciones(int id, String forma) {
		geometria = new Geometria(id);
		String resultado = geometria.getNom();
		int ids = geometria.getId();
		assertEquals(ids, id);
		assertEquals(resultado, forma);
	}

	// Probamos casos donde el número entero sea positio y negativo
	@Test
	public void testAreaCuadrado() {
		assertEquals(9, geometria.areacuadrado(3));
		assertEquals(25, geometria.areacuadrado(-5));
	}

	@Test
	public void testAreaCirculo() {
		double resultado = geometria.areaCirculo(25);
		double esperado = 1963.5;
		assertEquals(esperado, resultado);

	}

	@Test
	public void testAreaTriangulo() {
		int resultadoNeg = geometria.areatriangulo(-3, 4);
		int esperadoNeg = -6;
		int resultado = geometria.areatriangulo(3, 4);
		int esperado = 6;
		// assertEquals(esperado, resultado);
		assertEquals(esperadoNeg, resultadoNeg);
		assertEquals(esperado, resultado);
	}

	@Test
	public void testAreaRectangulo() {
		int resultado = geometria.arearectangulo(12, 18);
		int esperado = 216;
		assertEquals(esperado, resultado);
		assertEquals(-12, geometria.arearectangulo(-3, 4));
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
	@ParameterizedTest(name = "{index} => B={0}, b={1}, h={2}")
	@CsvSource({ "5, 2, 10", "10, 5, 3", "12, 15, 14", "-6, 4, 25", "15, -3, -10" })
	public void testAreaTrapecio(int B, int b, int h) {
		double resultado = geometria.areatrapecio(B, b, h);
		double esperado = Math.abs(((B + b) / 2) * h);
		int delta = 1;
		assertEquals(esperado, resultado, delta);

	}

	@Test
	public void testToString() {
		assertTrue(geometria.toString() instanceof String);
	}

	@Test
	public void testSettersAndGetters() {
		geometria.setId(8);
		assertEquals(8, geometria.getId());
		geometria.setNom("Trapecio");
		assertEquals("Trapecio", geometria.getNom());
		geometria.setArea(50.0);
		assertEquals(50.0, geometria.getArea(), 0.0001);
	}

	@AfterEach
	public void after() {
		geometria = null;
	}

}
