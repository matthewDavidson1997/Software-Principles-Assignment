package expense_system;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

class Application {
    // fields
    private List<Team> teams;

    // constructor
    public Application() {
        this.teams = new ArrayList<>();
    }

    // methods
    public List<Team> getTeams() {
        return this.teams;
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public Team findTeam(User user) {
        for(int i = 0; i < this.teams.size(); i++) {
            Team team = this.teams.get(i);
            if (team.getUsers().contains(user)) {
                return team;
            }
        }
        return null;
    }

    public void recordExpense(Expense expense) {
        User user = expense.getUser();
        Team team = this.findTeam(user);
        Budget budget = team.getBudget();
        budget.recordExpense(expense);

    }

    public static void main(String[] args) throws ParseException {

        Application app = new Application();
        Team team1 = new Team("Team 1", 1000.0);
        app.addTeam(team1);
        Budget budget = team1.getBudget();
        budget.addFunds(100);

        User user1 = new User("Joe", "Bloggs");
        User user2 = new User("Bob", "Roberts");

        team1.addUser(user1);
        team1.addUser(user2);

        Expense expense1 = new Expense(250.0, "Dinner", "20/10/21", user1);
        app.recordExpense(expense1);

        Expense expense2 = new Expense(100.0, "Stationery", "22/10/21", user2);
        app.recordExpense(expense2);

        budget.printExpenses();

        System.out.println(team1.getTeamName() + " " + team1.getBudget());
        System.out.println(team1.getUsers());

    }
}