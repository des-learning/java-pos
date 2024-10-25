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

  public MainMenuScreen() {
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
          new UserManagementScreen().run();
          break;
        case 2:
          new InventoryManagementScreen().run();
          break;
        case 3:
          new SaleTransactionScreen().run();
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
