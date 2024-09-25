package alexcharlesworth.rest.pojos;

public class CreateUserForm extends User {
    private String password;

    public CreateUserForm(String email, String first_name, String surname, String password, String password1) {
        super(email, first_name, surname, password);
        this.password = password1;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "CreateUserForm{" +
                super.toString() +
                "password='" + password + '\'' +
                '}';
    }
}

