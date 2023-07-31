package modulo01;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PersonAge {

    public static long getPersonAge(LocalDate birthDate) {
    	if (birthDate.isAfter(LocalDate.now())) return 0;
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }
}
