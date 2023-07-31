package moduloPreparacao;

import moduloPreparacao.domain.Product;
import moduloPreparacao.services.OrderCalculationService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderCalculationServiceTest {

	@Test
	public void shouldReturnTheSumOfProductPricesWhenAListOfProductsWasPassed() {
		//Given
		List<Product> products = new ArrayList<>();
		products.add(new Product("uuid", "produto", "test", "imagem", 4.5, 1));
		products.add(new Product("uuid", "produto", "test", "imagem", 5, 1));
		products.add(new Product("uuid", "produto", "test", "imagem", 5, 1));
		
		//When
		OrderCalculationService orderCalculationService = new OrderCalculationService();
		double resultado = orderCalculationService.sumProductsValue(products);
		
		//Then
		assertEquals(14.5, resultado, 0.00);
	}
	
}
