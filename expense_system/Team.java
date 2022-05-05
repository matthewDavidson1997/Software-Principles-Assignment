package expense_system;

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

    // constructor
    public Team(String name, double budget) {
        this.teamName = name;
        this.budget = new Budget(budget);
        
    }

    // methods
    public void addUser(User user) {
        this.users.add(user);
        //user.setTeam(this);
    }

    public String getTeamName() {
        return this.teamName;
    }

    public Budget getBudget() {
        return this.budget;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public String toString() {
        return this.teamName;
    }
}