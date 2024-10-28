import java.util.Scanner;

public class UpdateProductScreen {
    private InventoryManagement inventoryManagement;
    private Product product;

    public UpdateProductScreen(int productId, InventoryManagement inventoryManagement) {
        this.inventoryManagement = inventoryManagement;
        Product product = inventoryManagement.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException("product not found");
        }
        this.product = product;
    }

    public void run() {
        Scanner input = new Scanner(System.in);

        System.out.print("SKU (enter untuk tidak diubah): ");
        String newSKU = input.nextLine();
        String SKU = newSKU.isBlank() ? product.getSKU() : newSKU;

        System.out.print("Nama (enter untuk tidak diubah): ");
        String newName = input.nextLine();
        String name = newName.isBlank() ? product.getName() : newName;

        int newPrice = new IntegerInput("Harga (enter untuk tidak diubah): ", -1).getInput();
        int price = newPrice <= 0 ? product.getPrice() : newPrice;

        System.out.print("Aktif (enter untuk tidak diubah): ");
        String newActive = input.nextLine();
        boolean active = newActive.isBlank() ? product.isActive() : newActive.equalsIgnoreCase("y");

        try {
            inventoryManagement.update(product.getId(), SKU, name, price, active);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
