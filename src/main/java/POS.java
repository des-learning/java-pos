import java.util.Scanner;

public class POS {
  // untuk menerima input keyboard
  Scanner input;

  // menampung user yang sedang login, null berarti belum login
  private User user;

  // menampung flag apakah program berhenti atau terus berjalan
  private boolean exit;
  UserManagement userManagement;
  MainMenuScreen mainMenu = new MainMenuScreen();

  public POS() {
    input = new Scanner(System.in);
    user = null;
    exit = false;

    userManagement = new UserManagement();
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
