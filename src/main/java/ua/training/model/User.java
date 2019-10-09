package ua.training.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class User implements Serializable {
    private final static long serialVersionUID = 1L;
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public enum Role {GUEST, USER, ADMIN}

    private Role role;
    private LocalDateTime created;


    public User() {    }
    public User(int id){this.id=id;}
    public User( String login, String password, String firstName, String lastName, String email, Role role,LocalDateTime created) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int user_id) {
        this.id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime convertToLocalDateTime(Timestamp timestap) {
        if(timestap!=null){
            return timestap.toLocalDateTime();
        }
        return null;
    }

    public Timestamp convertToTimestap(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", created=" + created +
                '}';
    }
}
