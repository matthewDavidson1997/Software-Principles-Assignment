package expense_system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Team class keeps a record of the users in the team, the team's budget, and the team name.
 */
public class Team {

    // fields
    private String teamName;
    private Budget budget;
    private List<User> users;
    public static List<String> teamRow = new ArrayList<String>();
    public static List<Double> budgetRow = new ArrayList<Double>();
    public static List<Team> teams = new ArrayList<Team>();

    // CONSTRUCTOR
    public Team(String name, double budget) {
        this.teamName = name;
        this.budget = new Budget(budget);
        this.users = new ArrayList<>();
    }

    // METHODS
    // to string
    public String toString() {
        return this.teamName;
    }

    // getters
    public String getTeamName() {
        return this.teamName;
    }
    public Budget getBudget() {
        return this.budget;
    }
    public List<User> getUsers() {
        return this.users;
    }
    
    // other methods

    //A method to record a user as being a member of the team.
    public void addUser(User user) {
        // We check that the user instance was constructed with a reference to this team
        // before adding it to the list (there must be a better way of doing this??)
        if (user.getTeam() == this) {
            this.users.add(user);
        }
    }
}
