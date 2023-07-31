package modulo02;

import java.util.List;

import modulo02.domain.Client;
import modulo02.domain.Order;
import modulo02.domain.Product;

public class OrderProcessor {
	
	private ProductsOrderService productsOrderService;
	private OrderCalculationService orderCalculationService;
	private OrderService orderService;
	
	public OrderProcessor (ProductsOrderService productsOrderService, OrderCalculationService orderCalculationService, OrderService orderService) {
		this.productsOrderService = productsOrderService;
		this.orderCalculationService = orderCalculationService;
		this.orderService = orderService;
	}

	public Order process(String orderUuid) {
		Order order = new Order();
		order.setOrderUuid(orderUuid);
		
		List<Product> products = this.productsOrderService.searchOrderProducts(orderUuid);
		order.setProducts(products);
		double valorTotal = this.orderCalculationService.sumProductsValue(products);
		order.setTotalValue(valorTotal);
		Client client = this.orderService.findUserData(orderUuid);
		order.setClient(client);

		return order; 
	}
	
}
