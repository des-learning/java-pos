public class SaleItem {
    private Product product;
    private int quantity;

    public SaleItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSubtotal() {
        return this.getProduct().getPrice() * this.getQuantity();
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
