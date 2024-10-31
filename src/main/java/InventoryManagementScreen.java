public class InventoryManagementScreen {
  private MenuNavigation menu;
  private boolean exit;
  private InventoryManagement inventoryManagement;

  public InventoryManagementScreen(InventoryManagement inventoryManagement) {
    menu = new MenuNavigation(new String[] {
        "Tambah produk baru",
        "List produk",
        "Kembali ke menu utama",
    });
    this.inventoryManagement = inventoryManagement;
    resetState();
  }

  public void run() {
    while (!shouldExit()) {
      menu.showAndSelectMenu();

      switch (menu.getSelectedMenu()) {
        case 1:
          new NewProductScreen(inventoryManagement).run();
          break;
        case 2:
          new ListProductScreen(inventoryManagement).run();
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
