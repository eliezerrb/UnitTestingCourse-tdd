package moduloPreparacao.services;

import moduloPreparacao.PaymentService;
import moduloPreparacao.domain.Order;
import moduloPreparacao.domain.Product;
import moduloPreparacao.domain.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProcessor {

	@Autowired
	private ProductsOrderService productsOrderService;
	@Autowired
	private OrderCalculationService orderCalculationService;
	
	@Autowired
	private PaymentService paymentService;

	public Order process(String orderUuid) {
		Order order = new Order();
		order.setOrderUuid(orderUuid);
		
		List<Product> products = this.productsOrderService.searchOrderProducts(orderUuid);
		order.setProducts(products);
		double valorTotal = this.orderCalculationService.sumProductsValue(products);
		order.setTotalValue(valorTotal);

		return order; 
	}

	public String test() {
		Order order = new Order();
		StatusEnum status = paymentService.processPayment(order);
		if (status == StatusEnum.SUCCESS) {
			return "Success";
		}
		return "Fail";
	}
	
}
