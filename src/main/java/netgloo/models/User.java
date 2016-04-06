package netgloo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userIdp;

    @NotNull
    @Size(min = 3, max = 80)
    private String email;

    @NotNull
    @Size(min = 2, max = 80)
    private String userName;

    private String password;

    private String role;

    public User() {
    }

    public User(Integer userIdp, String email, String userName, String password, String role) {
        this.userIdp = userIdp;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User(Integer userIdp) {
        this.userIdp = userIdp;
    }

    public Integer getUserIdp() {
        return userIdp;
    }

    public void setUserIdp(Integer userIdp) {
        this.userIdp = userIdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [userIdp=" + userIdp + ", email=" + email + ", userName=" + userName + ", password=" + password
                + ", role=" + role + "]";
    }

} // class User
