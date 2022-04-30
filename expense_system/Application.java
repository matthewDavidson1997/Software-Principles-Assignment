package expense_system;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Application {
    // fields
    private List<Team> teams;

    boolean userValidated = false;
    String currentUser;

    // constructor
    public Application() {
        this.teams = new ArrayList<>();
    }

    // methods

    public void setCurrentUser(String user) {
        currentUser = user;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void takeUserCredentials(){
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your username: ");
            String userName = scanner.nextLine();
            System.out.println("Please Enter your password: ");
            String password = scanner.nextLine();
            validateUser(userName, password);
        }
        while (!userValidated);
    }

    public void validateUser(String userName, String password) {
        
        if (userName.equals("TestUser") && password.equals("password")) {
            System.out.print("Login successful\n\n");
            setCurrentUser(userName);
            userValidated = true;
        } else {
            System.out.println("Login unsuccessful, please enter valid credentials.");
            userValidated = false;
        }
    }

    public int takeUserChoice(){
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;
        do {
            try {
                System.out.println("Please enter your choice: ");
                userChoice = scanner.nextInt();  
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid type choice. ");
            }
            scanner.nextLine();
        } while (userChoice <= 0);
        return userChoice;
    }


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

        User user1 = new User("TestUser");
        User user2 = new User("SecondTestUSer");

        team1.addUser(user1);
        team1.addUser(user2);

        Expense expense1 = new Expense(250.0, "Dinner", "20/10/21", user1);
        app.recordExpense(expense1);

        Expense expense2 = new Expense(100.0, "Stationery", "22/10/21", user2);
        app.recordExpense(expense2);

        Menu homeMenu = new Menu();
        homeMenu.createHomeMenu();

        budget.printExpenses();

        System.out.println(team1.getTeamName() + " " + team1.getBudget());
        System.out.println(team1.getUsers());

        
        

    }
}