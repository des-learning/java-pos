import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {
    private Map<String, Product> products;

    public InventoryManagement() {
        products = new HashMap<>() {
            {
                put("p001", new Product(1, "p001", "Product 1", 10000, true));
                put("p002", new Product(2, "p002", "Product 2", 10000, true));
                put("p003", new Product(3, "p003", "Product 3", 10000, true));
            }
        };
    }

    public Product create(String SKU, String name, int price, boolean active) {
        if (products.containsKey(SKU)) {
            throw new IllegalArgumentException("product SKU exists");
        }

        if (price < 0) {
            throw new IllegalArgumentException("invalid price");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("invalid name");
        }

        Product productWithHighestID = products.values().stream().max(Comparator.comparingInt(Product::getId)).get();
        int highestId = productWithHighestID == null ? 1 : productWithHighestID.getId() + 1;

        Product newProduct = new Product(highestId, SKU, name, price, active);
        products.put(SKU, newProduct);
        return newProduct;
    }

    public Product update(int id, String SKU, String name, int price, boolean active) {
        Product product = getProductById(id);
        if (product == null) {
            throw new IllegalArgumentException("product not found");
        }

        product.setSKU(SKU);
        product.setName(name);
        product.setPrice(price);
        product.setActive(active);

        return product;
    }

    public Product getProductById(int id) {
        return products.values().stream().filter((Product p) -> p.getId() == id).findFirst().orElse(null);
    }

    public Product getProductBySKU(String SKU) {
        return products.values().stream().filter((Product p) -> p.getSKU().equals(SKU)).findFirst().orElse(null);
    }

    public Collection<Product> list() {
        return products.values();
    }
}
