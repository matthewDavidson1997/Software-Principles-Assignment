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
    public static String currentUser;

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
            System.out.println("Please enter your password: ");
            String password = scanner.nextLine();
            validateUser(userName, password);
        }
        while (!userValidated);
    }

    public void validateUser(String userName, String password) {

        for (int i = 1; i < User.users.size() + 1; i++) {

            if (userName.equals(User.usernameRow.get(i).toString())) {
                System.out.println("Username matches");
                
                if (password.equals(User.passwordRow.get(i))) {
                    System.out.println("Username and password match");
                    System.out.print("Login successful\n\n");
                    currentUser = userName;
                    System.out.println(currentUser);
                    userValidated = true;
                    break;
                }
                
            }
            
        }
        System.out.println("Username or password is incorrect, try again.");

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
        User.scanUsersCSV();
        Expense.scanExpensesCSV();

        Team team1 = new Team("Team 1", 1000.0);
        app.addTeam(team1);
        Budget budget = team1.getBudget();
        budget.addFunds(100);

        

        Menu homeMenu = new Menu();
        homeMenu.createHomeMenu();

 

        
        

    }
}