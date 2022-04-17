package expense_system;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String teamName;
    private Budget budget;
    private List<User> users = new ArrayList<>();

    public Team(String name, double budget) {
        this.teamName = name;
        this.budget = new Budget(budget);
    }

    public void addUser(User user) {
        this.users.add(user);
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