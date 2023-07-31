package modulo01;

import modulo01.domain.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {

	@Test
	public void spyTest() {
		List<Employee> employees = Mockito.spy(ArrayList.class);
		Employee one = new Employee("Bilbo Baggins", "burglar");
		Employee two = new Employee("Frodo Baggins", "thief");
		Employee three = new Employee("Evandro", "thief");

		employees.add(one);
		employees.add(two);

		Mockito.verify(employees).add(one);
		Mockito.verify(employees).add(two);
		Mockito.verify(employees).add(three);
	}
}
