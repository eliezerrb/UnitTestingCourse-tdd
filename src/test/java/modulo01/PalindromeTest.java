package modulo01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeTest {

	@Test
	public void deveRetornarTrueQuandoForPassadoUmaFrasePalindroma() {
		boolean resultado = Palindrome.isPalindrome("ama");

		Assertions.assertTrue(resultado);
	}
	
	@Test
	public void deveRetornarFalseQuandoForPassadoUmaFraseNaoPalindroma() {
		boolean resultado = Palindrome.isPalindrome("asdf");

		Assertions.assertFalse(resultado);
	}

	@Test
	public void deveRetornarTrueQuandoForPassadaUmaFrasePalindromaComEspacos() {
		boolean resultado = Palindrome.isPalindrome("subi no onibus");

		Assertions.assertTrue(resultado);
	}
	
	@Test
	public void deveRetornarFalseQuandoForPassadaUmTextoVazio() {
		boolean resultado = Palindrome.isPalindrome("");

		Assertions.assertFalse(resultado);
	}
	
	@Test
	public void deveRetornarFalseQuandoForPassadaUmTextoApenasComEspacos() {
		boolean resultado = Palindrome.isPalindrome("   ");

		Assertions.assertFalse(resultado);
	}
	
	@Test
	public void deveRetornarFalseQuandoForPassadaUmValorNulo() {
		boolean resultado = Palindrome.isPalindrome(null);

		Assertions.assertFalse(resultado);
	}
	
	@Test
	public void deveRetornarTrueQuandoForPassadaUmaPalavraComCaracteresEmCaixaAlta() {
		boolean resultado = Palindrome.isPalindrome("SubINoOnibus");

		Assertions.assertTrue(resultado);
	}
}
