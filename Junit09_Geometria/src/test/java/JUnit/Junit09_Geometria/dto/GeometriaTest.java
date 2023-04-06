package JUnit.Junit09_Geometria.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import JUnit.Junit09_Geometria.dto.Geometria;

class GeometriaTest {
	Geometria geometria = new Geometria();
	Geometria geometria2 = new Geometria(1);

	@Test
	void testAreaCuadrado() {
		int resultado = geometria.areacuadrado(5);
		int esperado = 25;
		assertEquals(esperado, resultado);
	}
	void testareaCirculo() {
		
	}

}
