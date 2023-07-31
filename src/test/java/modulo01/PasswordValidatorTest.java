package modulo01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest {

    @Test
    public void shouldReturnTrueWhenPasswordWithNumbersIsPassed() {
        boolean result = PasswordValidator.passwordHasNumbers("234234");
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenPasswordWithoutNumbersIsPassed() {
        boolean result = PasswordValidator.passwordHasNumbers("evandro");
        Assertions.assertFalse(result);
    }
    
    @Test
    public void deveRetornarTrueQuandoForPassadaUmaSenhaComNumerosNoInicio() {
        boolean result = PasswordValidator.passwordHasNumbers("123123evandro");
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenPasswordIsEqualBirthdate() {
        LocalDate birthdate = LocalDate.of(1997,07, 18);
        boolean result = PasswordValidator.passwordContainsBirthdate("18071997", birthdate);
        assertTrue(result);
    }
    @Test
    public void deveRetornarTrueQuandoForPassadaADataDeNascimentoNoFormatoIngles() {
        LocalDate birthdate = LocalDate.of(1997,07, 18);
        boolean result = PasswordValidator.passwordContainsBirthdate("19970718", birthdate);
        Assertions.assertFalse(result);
    }
}
