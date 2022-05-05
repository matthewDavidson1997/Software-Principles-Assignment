package expense_system;
import java.io.*;
import java.util.*;


/**
 * The User class stores key information about a user in the system.
 */
public class User {

    // FIELDS
    private String username;
    private String password;
    private Team team;

    // CONSTRUCTOR
    public User(String username, String password, Team team) {
        this.username = username;
        this.password = password;
        // Add a record of the team to the user
        this.team = team;
        // Add a record of the user to the team
        team.addUser(this);
    }

    // METHODS
    // to string
    public String toString() {
        return this.username;
    }

    // getters
    public Team getTeam() {
        return this.team;
    }
    public String getPassword() {
        return this.password;
    }
    public String getUsername() {
        return this.username; 
    }

    // setters
    public void setPassword(String password) {
        this.password = password;
    }
}
