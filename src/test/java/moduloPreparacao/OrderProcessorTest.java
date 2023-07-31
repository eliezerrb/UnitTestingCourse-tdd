package moduloPreparacao;

import moduloPreparacao.domain.Order;
import moduloPreparacao.domain.Product;
import moduloPreparacao.domain.StatusEnum;
import moduloPreparacao.services.OrderCalculationService;
import moduloPreparacao.services.ProductsOrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class OrderProcessorTest {

	@Mock
	ProductsOrderService productsOrderService;

	@Mock
	OrderCalculationService orderCalculationService;

	@Mock
	PaymentService paymentService;

	@InjectMocks
	OrderProcessor orderProcessor;

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
		OrderProcessor orderProcessor = new OrderProcessor(productsOrderService, orderCalculationService, paymentService);
		
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
		OrderProcessor orderProcessor = new OrderProcessor(productsOrderService, orderCalculationService, paymentService);
		
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
		OrderProcessor orderProcessor = new OrderProcessor(productsOrderService, orderCalculationService, paymentService);
		
		// ###### Executando o método a ser testado!
		Order orderFinal = orderProcessor.process(orderUuid);
		// #####
		
		Mockito.verify(orderCalculationService).sumProductsValue(products);
		Assertions.assertEquals(valorTotal, orderFinal.getTotalValue(), 0.000);
	}
	
	@Test
	public void shouldUpdateOrderStatusToSuccessWhenPaymentSuccess() {
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
		Mockito.when(paymentService.processPayment(any(Order.class))).thenReturn(StatusEnum.SUCCESS);
		
		// Fez a injeção de dependência
		//OrderProcessor orderProcessor = new OrderProcessor(productsOrderService, orderCalculationService, paymentService);
		
		// ###### Executando o método a ser testado!
		Order orderFinal = orderProcessor.process(orderUuid);
		// #####
		
		Mockito.verify(paymentService).processPayment(any(Order.class));
		Assertions.assertEquals(StatusEnum.SUCCESS, orderFinal.getStatus());
	}
}
