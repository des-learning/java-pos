public class AuthenticationManager {
    private UserManagement userManagement;
    private User user;

    public AuthenticationManager(UserManagement userManagement) {
        this.user = null;
        this.userManagement = userManagement;
    }

    public void authenticate(String username, String password) {
        user = this.userManagement.authenticate(username, password);
    }

    public boolean isLoggedIn() {
        return this.user != null;
    }

    public void logout() {
        this.user = null;
    }

    public User getAuthenticatedUser() {
        return this.user;
    }
}
