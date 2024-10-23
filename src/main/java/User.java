/**
 * menampung informasi user dan role
 */
public class User {
  private int id;
  private String name;
  private String username;
  private String password;
  private String role;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUsername() {
    return username;
  }

  public String getRole() {
    return role;
  }

  public User(int id, String name, String username, String password, String role) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
    this.role = role;
  }

  /**
   * melakukan authentication terhadap user menggunakan password
   **/
  public boolean authenticate(String password) {
    return this.password.equals(password);
  }
}
