package modulo02.domain;

public class Product {
    private String productUuid;

    private String name;

    private String description;

    private String image;

    private double price;

    private int quantity;

    public Product(String productUuid, String name, String description, String image, double price, int quantity) {
		super();
		this.productUuid = productUuid;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
	}

	public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int stock) {
        this.quantity = stock;
    }
}
