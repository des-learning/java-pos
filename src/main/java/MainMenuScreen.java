/**
 * class ini menampilkan navigasi menu utama
 *
 * menggunakan teknik composition dengan
 * menggunakan MenuNavigation sebagai object untuk
 * memanage navigasi menu
 **/
public class MainMenuScreen {
  private MenuNavigation menu;
  private boolean exit;
  private UserManagement userManagement;
  private InventoryManagement inventoryManagement;
  private AuthenticationManager authenticationManager;
  private SaleTransactionManager saleTransactionManager;

  public MainMenuScreen(UserManagement userManagement, InventoryManagement inventoryManagement,
                        SaleTransactionManager saleTransactionManager, AuthenticationManager authenticationManager) {
    this.userManagement = userManagement;
    this.inventoryManagement = inventoryManagement;
    this.authenticationManager = authenticationManager;
    this.saleTransactionManager = saleTransactionManager;

    menu = new MenuNavigation(new String[] {
        "Managemen user",
        "Managemen inventori",
        "Transaksi penjualan",
        "Laporan",
        "Keluar",
    });
    resetState();
  }

  public void run() {
    while (!shouldExit()) {
      menu.showAndSelectMenu();

      switch (menu.getSelectedMenu()) {
        case 1:
          new UserManagementScreen(userManagement).run();
          break;
        case 2:
          new InventoryManagementScreen(inventoryManagement).run();
          break;
        case 3:
          new SaleTransactionScreen(this.inventoryManagement, this.saleTransactionManager, this.authenticationManager.getAuthenticatedUser()).run();
          break;
        case 4:
          new ReportScreen().run();
          break;
        case 5:
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
