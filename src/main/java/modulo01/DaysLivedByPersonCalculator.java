package modulo01;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DaysLivedByPersonCalculator {

    public static long getDaysLivedByPerson(LocalDate bornDate, LocalDate lastLivedDate) {
        long days = ChronoUnit.DAYS.between(bornDate, lastLivedDate);
        return days;
    }
}
