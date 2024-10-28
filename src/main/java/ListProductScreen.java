import java.util.Scanner;

public class ListProductScreen {
    private InventoryManagement inventoryManagement;

    public ListProductScreen(InventoryManagement inventoryManagement) {
        this.inventoryManagement = inventoryManagement;
    }

    public void run() {
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("-".repeat(101));
            System.out.printf("| %5s | %20s | %20s | %20s | %20s |\n", "ID", "Nama", "SKU", "Harga Satuan", "Aktif");
            System.out.println("-".repeat(101));
            for (Product p : inventoryManagement.list()) {
                System.out.printf("| %5d | %20s | %20s | %20s | %20s |\n", p.getId(), p.getName(), p.getSKU(), p.getPrice(), p.isActive() ? "Y" : "T");
            }
            System.out.println("-".repeat(101));

            int selectedProductId = new IntegerInput("Pilih produk yang akan di-update (0 untuk kembali): ", 0).getInput();
            if (selectedProductId == 0) {
                break;
            }

            new UpdateProductScreen(selectedProductId, inventoryManagement).run();
        } while (true);
    }
}
