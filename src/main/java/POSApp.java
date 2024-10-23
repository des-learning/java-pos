import java.util.Scanner;

public class POSApp {
  // untuk menerima input keyboard
  Scanner input;
  // menampung user yang sedang login, null berarti belum login
  private User user;
  // menampung flag apakah program berhenti atau terus berjalan
  private boolean exit;
  // list menu
  private String[] menu;
  UserManagement userManagement;

  public POSApp() {
    input = new Scanner(System.in);
    user = null;
    exit = false;

    userManagement = new UserManagement();

    menu = new String[] {
        "Managemen user",
        "Managemen inventori",
        "Transaksi penjualan",
        "Laporan",
        "Keluar",
    };
  }

  private boolean isLoggedIn() {
    return user != null;
  }

  private boolean shouldExit() {
    return exit;
  }

  private void mainMenu() {
    while (isLoggedIn()) {
      for (int i = 0; i < menu.length; i++) {
        System.out.printf("%d. %s\n", i + 1, menu[i]);
      }
      System.out.printf("Menu (1-%d): ", menu.length);
      Integer navigateTo = Integer.parseInt(input.nextLine());

      switch (navigateTo) {
        case 5: // Keluar
          user = null;
      }
    }
  }

  private void loginScreen() {
    while (!isLoggedIn()) {
      System.out.print("Username (enter untuk keluar): ");
      String username = input.nextLine();
      if (username.equals("")) {
        exit = true;
        break;
      }

      System.out.print("Password: ");
      String password = input.nextLine();

      user = this.userManagement.authenticate(username, password);
    }
  }

  public void run() {
    while (!shouldExit()) {
      loginScreen();
      mainMenu();
    }

    System.out.println("Bye-bye");
  }

  public static void main(String[] args) {
    POSApp app = new POSApp();

    app.run();
  }
}
