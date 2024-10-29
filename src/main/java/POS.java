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

  // menampung flag apakah program berhenti atau terus berjalan
  private boolean exit;

  // dependencies
  private UserManagement userManagement;
  private InventoryManagement inventoryManagement;
  private AuthenticationManager authenticationManager;
  private SaleTransactionManager saleTransactionManager;
  private MainMenuScreen mainMenu;

  // constructor
  public POS() {
    input = new Scanner(System.in);
    exit = false;

    userManagement = new UserManagement();
    authenticationManager = new AuthenticationManager(userManagement);
    inventoryManagement = new InventoryManagement();
    saleTransactionManager = new SaleTransactionManager();
    mainMenu = new MainMenuScreen(userManagement, inventoryManagement, saleTransactionManager, authenticationManager);
  }

  private void loginScreen() {
    while (!this.authenticationManager.isLoggedIn()) {
      System.out.print("Username (enter untuk keluar): ");
      String username = input.nextLine();
      if (username.equals("")) {
        exit = true;
        break;
      }

      System.out.print("Password: ");
      String password = input.nextLine();

      this.authenticationManager.authenticate(username, password);
    }
  }

  private boolean shouldExit() {
    return exit;
  }

  // main loop untuk menjalankan POS
  public void run() {
    while (!shouldExit()) {
      loginScreen();

      if (this.authenticationManager.isLoggedIn()) {
        mainMenu.run();
        this.authenticationManager.logout();
      }
    }

    System.out.println("Bye-bye");
  }
}
