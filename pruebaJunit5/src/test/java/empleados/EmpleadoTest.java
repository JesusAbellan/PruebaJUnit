package empleados;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EmpleadoTest {
	
	Empleado e;
	@BeforeEach
	void setup() {
		e = new Empleado("Prueba","Pruebín",33,12000);
	}
	
	static Stream<Arguments> paramsPlus(){
		return Stream.of(
				Arguments.of(false,new Empleado("Prueba","Pruebín",33,12000)),
				Arguments.of(true, new Empleado("Prueba2","Pruebín2",55,16000))
				);
	}
	@ParameterizedTest
	@MethodSource("paramsPlus")
	void testPlus(boolean exp, Empleado test) {
		assertEquals(exp,test.plus(2500));
	}
	
	static Stream<Arguments> paramsEquals(){
		return Stream.of(
				Arguments.of(true,new Empleado("Prueba","Pruebín",33,12000), new Empleado("Prueba","Pruebín",33,12000)),
				Arguments.of(false, new Empleado("Prueba2","Pruebín2",55,16000), new Empleado("Prueba","Pruebín",33,12000))
				);
	}
	@ParameterizedTest
	@MethodSource("paramsEquals")
	void testEqualsEmpleado(boolean exp, Empleado test1, Empleado test2) {
		assertEquals(exp,test1.equals(test2));
	}
	
	static Stream<Arguments> paramsCompare(){
		return Stream.of(
				Arguments.of(0,new Empleado("Prueba","Pruebín",33,12000), new Empleado("Prueba2","Pruebín2",33,12000)),
				Arguments.of(1, new Empleado("Prueba2","Pruebín2",55,16000), new Empleado("Prueba","Pruebín",33,12000)),
				Arguments.of(-1, new Empleado("Prueba2","Pruebín2",33,16000), new Empleado("Prueba","Pruebín",55,12000))
				);
	}

	@ParameterizedTest
	@MethodSource("paramsCompare")
	void testCompareTo(int exp, Empleado test1, Empleado test2) {
		assertEquals(exp,test1.compareTo(test2));
	}

	@Test
	void testToString() {
		String exp ="El empleado se llama "+"Prueba"+" "+"Pruebín"+" con "+33+" años " +
                "y un salario de "+12000.0;
		assertEquals(exp,e.toString());
	}
	
	////Los getters se consideran testeados al usarse en los otros test y coincidir con el resultado esperado.
}
