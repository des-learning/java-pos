import java.util.Scanner;

/**
 * aplikasi POS, class ini merupakan class yang menjadi program
 * utama dari POS.
 *
 * menampilkan halaman login jika belum login dan menampilkan menu
 * utama jika sudah login
 **/
public class POS {
  // untuk menerima input keyboard
  Scanner input;

  // menampung user yang sedang login, null berarti belum login
  private User user;

  // menampung flag apakah program berhenti atau terus berjalan
  private boolean exit;
  UserManagement userManagement;
  MainMenuScreen mainMenu;

  // constructor
  public POS() {
    input = new Scanner(System.in);
    user = null;
    exit = false;

    userManagement = new UserManagement();
    mainMenu = new MainMenuScreen(userManagement);
  }

  private boolean isLoggedIn() {
    return user != null;
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

  private boolean shouldExit() {
    return exit;
  }

  private void logout() {
    this.user = null;
  }

  // main loop untuk menjalankan POS
  public void run() {
    while (!shouldExit()) {
      loginScreen();

      if (isLoggedIn()) {
        mainMenu.run();
        logout();
      }
    }

    System.out.println("Bye-bye");
  }
}
