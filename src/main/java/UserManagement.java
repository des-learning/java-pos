import java.util.ArrayList;
import java.util.List;

/**
 * manage user
 *
 * implementasi proses bisnis untuk user
 *
 * sekarang ini fungsinya masih hanya authenticate user
 */
public class UserManagement {
  private List<User> users;

  public UserManagement() {
    users = new ArrayList<User>() {
      {
        add(new User(1, "admin", "admin", "admin", "Admin"));
        add(new User(2, "manager", "manager", "manager", "Manager"));
        add(new User(3, "kasir", "kasir", "kasir", "Kasir"));
      }
    };
  }

  /**
   * melakukan authentication terhadap user. input berupa username dan password
   * jika authentication berhasil, maka mengembalikan objek user
   * jika authentication gagal, mengembalikan null
   **/
  public User authenticate(String username, String password) {
    User loginUser = getByUsername(username);
    if (loginUser == null) {
      return null;
    }

    if (loginUser.getPassword().equals(password)) {
      return loginUser;
    }

    return null;
  }

  // Create Logic
  public User create(String name, String username, String password, String role) {
    if (!(role.equals("admin") || role.equals("manager") || role.equals("kasir"))) {
      throw new IllegalArgumentException("invalid role");
    }

    if (name.isBlank()) {
      throw new IllegalArgumentException("invalid name");
    }

    if (username.isBlank()) {
      throw new IllegalArgumentException("invalid username");
    }

    if (password.isBlank()) {
      throw new IllegalArgumentException("invalid password");
    }

    if (getByUsername(username) != null) {
      throw new IllegalArgumentException("user already exists");
    }

    User newUser = new User(getNextId(), name, username, password, role);
    users.add(newUser);
    return newUser;
  }

  // Read Logic
  public User getByUsername(String username) {
    for (User u : users) {
      if (u.getUsername().equals(username)) {
        return u;
      }
    }

    return null;
  }

  public User getById(int id) {
    for (User u : users) {
      if (u.getId() == id) {
        return u;
      }
    }

    return null;
  }

  public List<User> list() {
    return users;
  }

  // update logic
  public User changePassword(int id, String password) {
    if (password.isBlank()) {
      throw new IllegalArgumentException("invalid password");
    }

    User user = getById(id);
    if (user == null) {
      return null;
    }

    user.setPassword(password);
    return user;
  }

  // Generate next id untuk user, logic ini masih banyak flaw nya
  private int getNextId() {
    User lastUser = users.getLast();
    return lastUser == null ? 1 : lastUser.getId() + 1;
  }
}
