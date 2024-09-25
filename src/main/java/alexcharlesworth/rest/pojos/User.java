package alexcharlesworth.rest.pojos;

import java.util.Objects;

public class User {

    private String email;
    private String first_name;
    private String surname;

    private String password;

    public User(String email, String first_name, String surname, String password) {
        this.email = email;
        this.first_name = first_name;
        this.surname = surname;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", surname='" + surname + '\'' +
                 '}';
    }
}
