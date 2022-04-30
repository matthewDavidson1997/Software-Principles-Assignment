package expense_system;

public class User {

    // fields
    private String firstName;
    private String lastName;

    // constructor
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // methods
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    public void setCurrentUser() {
        
    }
}