package moduloPreparacao;

import java.util.List;

import moduloPreparacao.domain.Order;
import moduloPreparacao.domain.Product;
import moduloPreparacao.domain.StatusEnum;
import moduloPreparacao.services.OrderCalculationService;
import moduloPreparacao.services.ProductsOrderService;

public class OrderProcessor {
	
	private ProductsOrderService productsOrderService;
	private OrderCalculationService orderCalculationService;
	private PaymentService paymentService;
	
	public OrderProcessor (ProductsOrderService productsOrderService, OrderCalculationService orderCalculationService, PaymentService paymentService) {
		this.productsOrderService = productsOrderService;
		this.orderCalculationService = orderCalculationService;
		this.paymentService = paymentService;
	}

	public Order process(String orderUuid) {
		Order order = new Order();
		order.setOrderUuid(orderUuid);
		
		List<Product> products = this.productsOrderService.searchOrderProducts(orderUuid);
		order.setProducts(products);
		double valorTotal = this.orderCalculationService.sumProductsValue(products);
		order.setTotalValue(valorTotal);
		StatusEnum paymentResult = this.paymentService.processPayment(order);
		order.setStatus(paymentResult);

		return order;
	}
	
}
