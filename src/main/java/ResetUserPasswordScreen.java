import java.util.Scanner;

public class ResetUserPasswordScreen {
  private UserManagement userManagement;
  private User user;

  public ResetUserPasswordScreen(UserManagement userManagement, int userId) {
    this.userManagement = userManagement;
    user = this.userManagement.getById(userId);
    if (user == null) {
      throw new RuntimeException("User not found");
    }
  }

  public void run() {
    Scanner input = new Scanner(System.in);

    System.out.println("Name: " + user.getName());
    System.out.println("Username: " + user.getUsername());
    System.out.println("Role: " + user.getRole());

    System.out.print("Reset password (kosongkan untuk kembali): ");
    String resetPassword = input.nextLine();
    if (resetPassword.isBlank()) {
      return;
    }

    System.out.print("Verifikasi password: ");
    String verifyPassword = input.nextLine();

    if (!resetPassword.equals(verifyPassword)) {
      System.out.println("password not same");
      return;
    }

    try {
      userManagement.changePassword(user.getId(), resetPassword);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
