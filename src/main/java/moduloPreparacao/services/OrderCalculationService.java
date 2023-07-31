package moduloPreparacao.services;

import java.util.List;

import moduloPreparacao.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderCalculationService {

	public double sumProductsValue(List<Product> products) {
		return products.stream().map(el -> el.getPrice()).reduce(0.0, Double::sum);
	}

}
