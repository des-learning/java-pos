import java.util.Scanner;

public class NewUserScreen {
  private UserManagement userManagement;

  public NewUserScreen(UserManagement userManagement) {
    this.userManagement = userManagement;
  }

  public void run() {
    Scanner input = new Scanner(System.in);

    System.out.print("Name: ");
    String name = input.nextLine();

    System.out.print("Username: ");
    String username = input.nextLine();

    System.out.print("Role: ");
    String role = input.nextLine();

    System.out.print("Password: ");
    String password = input.nextLine();

    System.out.print("Password (verify): ");
    String verify = input.nextLine();

    if (!password.equals(verify)) {
      System.out.println("password not same");
      return;
    }

    try {
      userManagement.create(name, username, password, role);

      System.out.println("User " + username + " berhasil dibuat");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
