package modulo01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DaysLivedByPersonCalculatorTest {

    @Test
    public void ShouldReturn365DaysWhenANonLeapYearIsPassed() {
        long daysLived = DaysLivedByPersonCalculator.getDaysLivedByPerson(LocalDate.of(1997, 01, 01), LocalDate.of(1998, 01, 01));
        Assertions.assertEquals(365, daysLived);
    }

    @Test
    public void ShouldReturn366DaysWhenALeapYearIsPassed() {
        long daysLived = DaysLivedByPersonCalculator.getDaysLivedByPerson(LocalDate.of(2004, 01, 01), LocalDate.of(2005, 01, 01));
        Assertions.assertEquals(366, daysLived);
    }
}
