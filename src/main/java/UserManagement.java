/**
 * manage user
 *
 * sekarang ini fungsinya masih hanya authenticate user
 */
public class UserManagement {
  private User[] users;

  public UserManagement() {
    users = new User[] {
        new User(1, "admin", "admin", "admin", "Admin"),
        new User(2, "manager", "manager", "manager", "Manager"),
        new User(3, "kasir", "kasir", "kasir", "Kasir"),
    };
  }

  /**
   * melakukan authentication terhadap user. input berupa username dan password
   * jika authentication berhasil, maka mengembalikan objek user
   * jika authentication gagal, mengembalikan null
   **/
  public User authenticate(String username, String password) {
    User loginUser = getUser(username);
    if (loginUser == null) {
      return null;
    }

    if (loginUser.authenticate(password)) {
      return loginUser;
    }

    return null;
  }

  private User getUser(String username) {
    for (User u : users) {
      if (u.getUsername().equals(username)) {
        return u;
      }
    }

    return null;
  }
}
