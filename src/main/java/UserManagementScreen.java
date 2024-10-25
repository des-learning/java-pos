public class UserManagementScreen {
  private MenuNavigation menu;
  private boolean exit;

  public UserManagementScreen() {
    menu = new MenuNavigation(new String[] {
        "Tambah User Baru",
        "List User",
        "Kembali ke menu utama",
    });
    resetState();
  }

  public void run() {
    while (!shouldExit()) {
      menu.showAndSelectMenu();

      switch (menu.getSelectedMenu()) {
        case 1:
          System.out.println("Tampilkan screen user baru");
          break;
        case 2:
          System.out.println("Tampilkan screen list user");
          break;
        case 3:
          exit = true;
          break;
      }
    }
  }

  private boolean shouldExit() {
    return exit;
  }

  private void resetState() {
    exit = false;
  }
}
