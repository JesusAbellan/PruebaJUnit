package cuentas;

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
		assertEquals(100,c.getSaldo());
		
		assertThrows(Exception.class, () -> c.ingresar("Concepto",-100), "No se puede ingresar una cantidad negativa");
	}

	@Test
	void testRetirar() throws Exception {
		c.ingresar("Concepto", 1000);
		c.retirar("Concepto", 150);
		assertEquals(850,c.getSaldo());
		
		assertThrows(Exception.class, () -> c.retirar("Concepto", 2000), "Saldo insuficiente");
		assertThrows(Exception.class, () -> c.retirar("Concepto", -200), "No se puede retirar una cantidad negativa");
	}
	
	//getSaldo se considera Testeado debido a su uso en los otros test y su concordancia con lo esperado

	//addmovimiento se considera Testeado debido a su uso en los otros test y su concordancia con lo esperado
}
