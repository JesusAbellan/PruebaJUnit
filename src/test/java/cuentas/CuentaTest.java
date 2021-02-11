package cuentas;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaTest {
	
	Cuenta c;
	
	@BeforeEach
	void setup() {
		c = new Cuenta("123456789", "Test");
	}
	@Test
	void testIngresar() throws Exception {
		c.ingresar("Concepto", 100);
		assertThat(100.0, is(c.getSaldo()));
		
		IngresoNegativoException in = assertThrows(IngresoNegativoException.class, () -> c.ingresar("Concepto",-100));
		assertEquals("No se puede ingresar una cantidad negativa", in.getMessage());
	}

	@Test
	void testRetirar() throws Exception {
		c.ingresar("Concepto", 1000);
		c.retirar("Concepto", 150);
		assertThat(850.0, is(c.getSaldo()));
		
		SaldoInsuficienteException si = assertThrows(SaldoInsuficienteException.class, () -> c.retirar("Concepto", 2000));
		assertEquals("Saldo insuficiente",si.getMessage());
		IngresoNegativoException in = assertThrows(IngresoNegativoException.class, () -> c.retirar("Concepto", -200));
		assertEquals("No se puede retirar una cantidad negativa",in.getMessage());
	}
	
	//getSaldo se considera Testeado debido a su uso en los otros test y su concordancia con lo esperado

	//addmovimiento se considera Testeado debido a su uso en los otros test y su concordancia con lo esperado
}
