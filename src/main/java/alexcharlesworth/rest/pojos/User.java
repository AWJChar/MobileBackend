package alexcharlesworth.rest.pojos;

/*Stores User details which are returned to the frontend*/
public class User {

    private final String email;
    private final String first_name;
    private final String surname;
    private final String password;

    public User(String email, String first_name, String surname, String password) {
        this.email = email;
        this.first_name = first_name;
        this.surname = surname;
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
