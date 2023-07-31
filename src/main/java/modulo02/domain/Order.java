package modulo02.domain;

import java.util.List;

public class Order {

    private String orderUuid;

    private List<Product> products;

    private double totalValue;
    
    private Client client;

	public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
    
    public Client getClient() {
 		return client;
 	}

 	public void setClient(Client client) {
 		this.client = client;
 	}
}
