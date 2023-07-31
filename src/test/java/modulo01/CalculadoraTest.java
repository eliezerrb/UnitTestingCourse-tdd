package modulo01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

	@Test
	public void deveRetornarASomaDosValoresQuandoPassarValoresSimples() {
		// Given
		double valor1 = 1;
		double valor2 = 1;
		
		// When
		double resultado = Calculadora.soma(valor1, valor2);
		
		// Then
		// Apenas assert por test!
		assertEquals(2, resultado, 0);
	}

}
