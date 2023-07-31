package modulo02;

import modulo02.domain.Client;
import modulo02.domain.Order;
import modulo02.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderProcessorTest {

	@Mock
	private OrderService orderService;

	@Mock
	private ProductsOrderService productsOrderService;
	
	@Mock
	private OrderCalculationService orderCalculationService;
	
	@BeforeAll
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldSearchProductDetailsWhenArriveNewOrder() {
		String orderUuid = "86b3a06d-5531-4cc2-8acf-3de02a79900a";
		List<Product> products = new ArrayList<>();
		Order order = new Order();
		order.setOrderUuid(orderUuid);

		// Mockando a dependência da classe OrderProcessor
		ProductsOrderService productsOrderService = Mockito.spy(ProductsOrderService.class);
		// Mockando o método da dependencia
		Mockito.when(productsOrderService.searchOrderProducts(orderUuid)).thenReturn(products);
		Mockito.when(orderCalculationService.sumProductsValue(products)).thenReturn(0.0);
		
		// Fez a injeção de dependência
		OrderProcessor orderProcessor = new OrderProcessor(productsOrderService, orderCalculationService, orderService);
		
		// ###### Executando o método a ser testado!
		Order orderResponse = orderProcessor.process(orderUuid);
		// #####
		
		Mockito.verify(productsOrderService).searchOrderProducts(orderUuid);
	}
	
	@Test
	public void shouldSearchProductDetailsWhenArriveNewOrderWithMockedService() {
		String orderUuid = "86b3a06d-5531-4cc2-8acf-3de02a79900a";
		List<Product> products = new ArrayList<>();
		Order order = new Order();
		order.setOrderUuid(orderUuid);

		// Mockando o método da dependencia
		Mockito.when(productsOrderService.searchOrderProducts(orderUuid)).thenReturn(products);
		Mockito.when(orderCalculationService.sumProductsValue(products)).thenReturn(0.0);
		
		// Fez a injeção de dependência
		OrderProcessor orderProcessor = new OrderProcessor(productsOrderService, orderCalculationService, orderService);
		
		// ###### Executando o método a ser testado!
		orderProcessor.process(orderUuid);
		// #####
		
		Mockito.verify(productsOrderService).searchOrderProducts(orderUuid);
	}
	
	@Test
	public void shouldCalculateOrderTotalValueWhenArriveANewOrder() {
		String orderUuid = "86b3a06d-5531-4cc2-8acf-3de02a79900a";
		List<Product> products = new ArrayList<>();
		Order order = new Order();
		order.setOrderUuid(orderUuid);
		Product product01 = new Product("uuuid1123434", "name", "description", "http://imagem.com.br", 4.5, 10);
		Product product02 = new Product("uuuid1123434", "name", "description", "http://imagem.com.br", 4.5, 5);
		products.add(product01);
		products.add(product02);
		
		double valorTotal = 62.5;

		// Mockando o método da dependencia
		Mockito.when(productsOrderService.searchOrderProducts(orderUuid)).thenReturn(products);
		Mockito.when(orderCalculationService.sumProductsValue(products)).thenReturn(valorTotal);
		
		// Fez a injeção de dependência
		OrderProcessor orderProcessor = new OrderProcessor(productsOrderService, orderCalculationService, orderService);
		
		// ###### Executando o método a ser testado!
		Order orderFinal = orderProcessor.process(orderUuid);
		// #####
		
		Mockito.verify(orderCalculationService).sumProductsValue(products);
		Assertions.assertEquals(valorTotal, orderFinal.getTotalValue(), 0.000);
	}
	
	@Test
	public void shouldSearchUserEmailWhenProcessOrder() {
		Client client = new Client();
		client.setEmail("evandro@gmail.com");
		client.setName("evandro");
		String uuid = "asdfasdf";

		Mockito.when(productsOrderService.searchOrderProducts(uuid)).thenReturn(Arrays.asList());
		Mockito.when(orderCalculationService.sumProductsValue(Arrays.asList())).thenReturn(6.0);
		Mockito.when(orderService.findUserData(Mockito.anyString())).thenReturn(client);

		OrderProcessor orderProcessor = new OrderProcessor(productsOrderService, orderCalculationService, orderService);

		Order order = orderProcessor.process(Mockito.anyString());

		Mockito.verify(orderService).findUserData(Mockito.anyString());
		Assertions.assertEquals(client.getEmail(), order.getClient().getEmail());
	}
	
}
