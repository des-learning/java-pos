public class InventoryManagementScreen {
  private MenuNavigation menu;
  private boolean exit;

  public InventoryManagementScreen() {
    menu = new MenuNavigation(new String[] {
        "Tambah produk baru",
        "List produk",
        "Kembali ke menu utama",
    });
    resetState();
  }

  public void run() {
    while (!shouldExit()) {
      menu.showAndSelectMenu();

      switch (menu.getSelectedMenu()) {
        case 1:
          System.out.println("Tampilkan screen tambah produk baru");
          break;
        case 2:
          System.out.println("Tampilkan screen list produk");
          break;
        case 3:
          exit = true;
          break;
      }
    }
    resetState();
  }

  private boolean shouldExit() {
    return exit;
  }

  private void resetState() {
    exit = false;
  }
}
