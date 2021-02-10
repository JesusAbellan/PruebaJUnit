package cuentas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientoTest {
	
	Movimiento m;
	
	@BeforeEach
	void setup() {
		m = new Movimiento();
	}


	@Test
	void testSetConcepto() {
		m.setConcepto("Test");
		assertEquals("Test",m.getConcepto());
	}

	@Test
	void testSetImporte() {
		m.setImporte(100.56);
		assertEquals(100.56,m.getImporte());
	}
	
	//Los getters se consideran testeados al probarse en los otros test y coincidir con el resultado esperado.

}
