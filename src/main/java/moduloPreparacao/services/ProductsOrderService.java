package moduloPreparacao.services;

import java.util.ArrayList;
import java.util.List;

import moduloPreparacao.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProductsOrderService {
	
	public List<Product> searchOrderProducts(String orderUuid) {
		return new ArrayList<Product>();
	}

}
