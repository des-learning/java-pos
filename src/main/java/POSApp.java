import java.util.Scanner;

public class POSApp {
  // untuk menerima input keyboard
  Scanner input;
  // menampung user yang sedang login, null berarti belum login
  private User user;
  // menampung flag apakah program berhenti atau terus berjalan
  private boolean exit;
  // list user
  private User[] users;
  // list menu
  private String[] menu;

  public POSApp() {
    input = new Scanner(System.in);
    user = null;
    exit = false;

    users = new User[] {
        new User(1, "admin", "admin", "admin", "Admin"),
        new User(2, "manager", "manager", "manager", "Manager"),
        new User(3, "kasir", "kasir", "kasir", "Kasir"),
    };

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

  private User getUser(String username) {
    for (User u : users) {
      if (u.getUsername().equals(username)) {
        return u;
      }
    }

    return null;
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

      User loginUser = getUser(username);
      if (loginUser.authenticate(password)) {
        user = loginUser;
      }
    }
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
