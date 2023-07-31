package modulo01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PersonAgeTest {

    @Test
    public void deveRetornar18AnosQuandoADataNascimentoFor2005() {
        long age = PersonAge.getPersonAge(LocalDate.of(2005, 01, 01));
        boolean equal = 18 == age;
        Assertions.assertTrue(equal);
    }
    
    @Test
    public void deveRetornar19AnosQuandoADataNascimentoFor01062003() {
        long age = PersonAge.getPersonAge(LocalDate.of(2003, 06, 06));
        Assertions.assertEquals(20, age);
    }
    
    @Test
    public void deveRetornarZeroQuandoDeNascimentoForMaiorQueDataAtual() {
    	long age = PersonAge.getPersonAge(LocalDate.of(2025, 01, 01));
        Assertions.assertEquals(0, age);
    }
}
