import java.util.Scanner;

public class ListUserScreen {
  private UserManagement userManagement;

  public ListUserScreen(UserManagement userManagement) {
    this.userManagement = userManagement;
  }

  public void run() {
    Scanner input = new Scanner(System.in);

    do {
      System.out.println("-".repeat(83));
      System.out.printf("| %5s | %20s | %20s | %20s |\n", "ID", "Name", "Username", "Role");
      System.out.println("-".repeat(83));
      for (User user : userManagement.list()) {
        System.out.printf("| %5d | %20s | %20s | %20s |\n", user.getId(), user.getName(), user.getUsername(),
            user.getRole());
      }
      System.out.println("-".repeat(83));

      System.out.print("Pilih user (0 untuk keluar): ");
      try {
        int id = Integer.parseInt(input.nextLine());
        if (id == 0) {
          break;
        }
        // TODO: update user screen
      } catch (Exception e) {
      }
    } while (true);
  }
}
