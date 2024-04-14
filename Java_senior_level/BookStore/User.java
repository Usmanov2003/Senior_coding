public class User { 
    private String username; 
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String password) { 
        return this.password.equals(passowrd);
    }

    public String getUsername() {
        return username;
    }
}