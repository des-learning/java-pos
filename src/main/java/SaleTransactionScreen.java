import java.time.LocalDate;
import java.util.Scanner;

public class SaleTransactionScreen {
  private InventoryManagement inventoryManagement;
  private SaleTransactionManager saleTransactionManager;
  private User kasir;

  public SaleTransactionScreen(InventoryManagement inventoryManagement, SaleTransactionManager saleTransactionManager, User kasir) {
    this.inventoryManagement = inventoryManagement;
    this.saleTransactionManager = saleTransactionManager;
    this.kasir = kasir;
  }

  public void run() {
    SaleTransaction saleTransaction = this.saleTransactionManager.newTransaction(LocalDate.now(), kasir);
    System.out.println("Tanggal: " + saleTransaction.getDate());
    System.out.println("No Transaksi: " + saleTransaction.getTransactionNumber());
    System.out.println("Kasir: " + saleTransaction.getKasir().getName());
    do {
      printTransactionItems(saleTransaction);
      SaleItem item = inputItem(saleTransaction);
      if (item == null) {
        break;
      }
      saleTransaction.addItem(item);
    } while (true);

    if (saleTransaction.getItemsCount() > 0) {
      int payment = inputPayment(saleTransaction);
      saleTransactionManager.store(saleTransaction);
      printReceipt(saleTransaction, payment);
    }
  }

  private void printTransactionItems(SaleTransaction saleTransaction) {
    int count = 0;
    System.out.printf("| %3s | %20s | %20s | %20s | %10s | %20s |\n", "No.", "Nama", "SKU", "Harga Satuan", "Banyak", "Subtotal");
    for (SaleItem item: saleTransaction.getItems()) {
      System.out.printf("| %3d | %20s | %20s | %20d | %10d | %20d |\n", ++count, item.getProduct().getName(), item.getProduct().getSKU(), item.getProduct().getPrice(), item.getQuantity(), item.getSubtotal());
    }
    System.out.printf("| %84s: | %20d |\n", "Grand Total", saleTransaction.getGrandTotal());
  }

  private SaleItem inputItem(SaleTransaction saleTransaction) {
    Scanner input = new Scanner(System.in);
    do {
      String SKU = inputSKU(input);
      if (SKU.isBlank()) {
        return null;
      }

      Product product = findAndDisplayProduct(SKU);
      if (product == null) {
        continue;
      }

      int quantity = inputQuantity();
      return new SaleItem(product, quantity);
    } while (true);
  }

  private String inputSKU(Scanner input) {
    System.out.print("SKU (kosongkan untuk selesai): ");
    return input.nextLine();
  }

  private Product findAndDisplayProduct(String SKU) {
    Product product = inventoryManagement.getProductBySKU(SKU);
    if (product == null) {
      System.out.println("Produk tidak ditemukan");
      return null;
    }

    System.out.println("Nama barang: " + product.getName());
    System.out.println("Harga satuan: " + product.getPrice());
    return product;
  }

  private int inputQuantity() {
    IntegerInput input = new IntegerInput("Banyak: ");
    do {
      int quantity = input.getInput();
      if (quantity > 0) {
        return quantity;
      }
      System.out.println("Banyak harus > 0");
    } while (true);
  }

  private int inputPayment(SaleTransaction saleTransaction) {
    IntegerInput input = new IntegerInput("Pembayaran: ");
    do {
      int payment = input.getInput();
      if (payment >= saleTransaction.getGrandTotal()) {
        System.out.println("Kembalian: " + (payment - saleTransaction.getGrandTotal()));
        return payment;
      }
    } while (true);
  }

  private void printReceipt(SaleTransaction saleTransaction, int payment) {
    System.out.println("+" + "-".repeat(40) + "+");
    System.out.printf("| %38s |\n", "Faktur Penjualan");
    System.out.println("+" + "-".repeat(40) + "+");
    System.out.printf("| %10s: %26s |\n", "Tgl", saleTransaction.getDate());
    System.out.printf("| %10s: %26s |\n", "No", saleTransaction.getTransactionNumber());
    System.out.printf("| %10s: %26s |\n", "Kasir", saleTransaction.getKasir().getName());
    System.out.printf("| %10s: %26s |\n", "Item", saleTransaction.getItemsCount());
    System.out.printf("| %10s: %26s |\n", "Banyak", saleTransaction.getTotalItemsQuantity());
    System.out.println("+" + "-".repeat(40) + "+");

    for (SaleItem item: saleTransaction.getItems()) {
      System.out.printf("| %10s @ %5s x %4s = %10s |\n", item.getProduct().getName(), item.getProduct().getPrice(), item.getQuantity(), item.getSubtotal());
    }
    System.out.println("+" + "-".repeat(40) + "+");
    System.out.printf("| %16s: %20s |\n", "Grand Total", saleTransaction.getGrandTotal());
    System.out.printf("| %16s: %20s |\n", "Pembayaran", payment);
    System.out.printf("| %16s: %20s |\n", "Kembalian", payment-saleTransaction.getGrandTotal());
    System.out.println("+" + "-".repeat(40) + "+");
  }
}
