public class UserManagementScreen {
  private MenuNavigation menu;
  private boolean exit;
  private UserManagement userManagement;

  public UserManagementScreen(UserManagement userManagement) {
    this.userManagement = userManagement;

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
          new NewUserScreen(userManagement).run();
          break;
        case 2:
          new ListUserScreen(userManagement).run();
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
