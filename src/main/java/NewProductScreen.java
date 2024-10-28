import java.util.Scanner;

public class NewProductScreen {
    private InventoryManagement inventoryManagement;

    public NewProductScreen(InventoryManagement inventoryManagement) {
        this.inventoryManagement = inventoryManagement;
    }

    public void run() {
        Scanner input = new Scanner(System.in);

        System.out.print("SKU: ");
        String SKU = input.nextLine();

        System.out.print("Nama Produk: ");
        String name = input.nextLine();

        int price = new IntegerInput("Harga Satuan: ", 0).getInput();

        try {
            inventoryManagement.create(SKU, name, price, true);

            System.out.println("Product " + name + " [" + SKU + "] berhasil dibuat");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
