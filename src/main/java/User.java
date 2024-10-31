/**
 * menampung informasi user dan role
 * POJO - Plain Old Java Object
 * class ini cuma berfungsi sebagai model tanpa ada logic bisnis
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

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", username=" + username + ", role=" + role + "]";
  }

  public User(int id, String name, String username, String password, String role) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
    this.role = role;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
