package expense_system;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;


/**
 * The Menu class provides interface components for the User to interact with in the main Application. 
 */
public class Menu {
    
    // CONSTANTS
    public static final String DELIMITOR_LINE = " ---------------------------------------------------------------------";
    public static final String BLANK_LINE = "|                                                                     |";
    public static final String START_TEXT_LINE = "| ";
    public static final String END_TEXT_LINE = "|";
    public static final String INVALID_CHOICE_TEXT = "Invalid choice";
    public static final String PRODUCT_NAME = "feel good fund management system";

    // FIELDS
    private Application app;
    private boolean validChoice;

    // CONSTRUCTOR
    public Menu(Application app) throws NumberFormatException, ParseException, IOException {
        this.app = app;
        this.validChoice = false;
        this.createHomeMenu();
    }

    // Clear the screen (see https://stackoverflow.com/a/32295974)
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    // Helper to pad a string
    private static String padString(String string, int n) {
        return String.format("%-" + n + "s", string);
    }

    // Helper to print a line
    private static void printInfoLine(String string, int padding) {
        String pad = padString(string, padding);
        System.out.println(START_TEXT_LINE + pad + END_TEXT_LINE);
    }

    // What to do when we quit the Application
    private static void quitApp() {
        System.exit(0);
    }

    // Create the Home menu
    private void createHomeMenu() throws NumberFormatException, ParseException, IOException{
        clearScreen();  //cls
        System.out.println(DELIMITOR_LINE);  // delimitor
        printInfoLine(PRODUCT_NAME, 68);
        System.out.println(BLANK_LINE);  // blank line
        printInfoLine("Where would you like to go?", 68);
        System.out.println(DELIMITOR_LINE);  // delimitor
        printInfoLine("1. Login", 68);
        printInfoLine("2. About", 68);
        printInfoLine("3. Help Guide", 68);
        printInfoLine("4. Quit", 68);
        System.out.println(DELIMITOR_LINE + "\n");
        
        
        do{
            int userChoice = this.app.takeUserChoice();
            switch (userChoice) {
                case 1: createLoginMenu();
                        break;
                case 2: createAboutMenu();
                        break;
                case 3: createHelpGuideMenu("Home");
                        break;
                // Quiting will write CSV data back to files
                case 4: this.app.writeBackToFiles();
                        quitApp();
                        break;
                default: System.out.println(INVALID_CHOICE_TEXT);
            }
        }
        while (!validChoice);
    }

    // Create the Login menu
    private void createLoginMenu() throws NumberFormatException, ParseException, IOException{
        clearScreen();  // cls
        System.out.println(DELIMITOR_LINE);  // delimitor
        printInfoLine(PRODUCT_NAME, 68);
        System.out.println(BLANK_LINE);  // blank line
        printInfoLine("Please enter your username and password to continue", 68);
        System.out.println(DELIMITOR_LINE + "\n");  // delimitor

        // Request the user credentials to login
        this.app.takeUserCredentials();

        // Upon successful login
        this.createLoggedInMenu();
    }

    // Create the About menu
    private void createAboutMenu() throws NumberFormatException, ParseException, IOException{
        clearScreen();
        System.out.println(DELIMITOR_LINE);
        printInfoLine(PRODUCT_NAME, 68);
        System.out.println(BLANK_LINE); 
        printInfoLine("Redgate has always looked after its employees.", 68);
        printInfoLine("As such a 'Feel Good Fund' was established which", 68);
        printInfoLine("is money set aside for each team to do social", 68);
        printInfoLine("activities together and reclaim their expenses.", 68);
        System.out.println(BLANK_LINE);
        printInfoLine("This platform allows each team to track their", 68);
        printInfoLine("budget, seeing remaining budget, track expenses,", 68);
        printInfoLine("and submitting new expenses.", 68);
        System.out.println(BLANK_LINE);
        printInfoLine("It does not act as a replacement to the usual", 68);
        printInfoLine("process of expenses to claim back money spent.", 68);
        System.out.println(DELIMITOR_LINE);
        printInfoLine("Where would you like to go?", 68);
        System.out.println(DELIMITOR_LINE);
        printInfoLine("1. Home", 68);
        System.out.println(DELIMITOR_LINE + "\n");
        
        int userChoice = this.app.takeUserChoice();
        switch (userChoice) {
            case 1: createHomeMenu();
                break;
            default: System.out.println(INVALID_CHOICE_TEXT);
        }
    }

    // Create the Help menu
    public void createHelpGuideMenu(String goBackTo) throws NumberFormatException, ParseException, IOException{
        clearScreen();
        System.out.println(DELIMITOR_LINE);
        printInfoLine(PRODUCT_NAME, 68);
        System.out.println(BLANK_LINE);
        printInfoLine("This application allows you to view and enter", 68);
        printInfoLine("expenses associated with the feel good fund", 68);
        printInfoLine("to keep track of your team's budget.", 68);
        System.out.println(BLANK_LINE);
        printInfoLine("If you are having difficulty logging in", 68);
        printInfoLine("please contact your system admin.", 68);
        System.out.println(DELIMITOR_LINE);
        printInfoLine("Where would you like to go?", 68);
        System.out.println(DELIMITOR_LINE);
        printInfoLine("1. Back", 68); 
        System.out.println(DELIMITOR_LINE + "\n");
        
        int userChoice = this.app.takeUserChoice();
        switch (userChoice) {
            case 1: if (goBackTo.equals("Home")) {
                this.createHomeMenu();
                } else {
                    this.createLoggedInMenu();
                }
                break;
            default: System.out.println(INVALID_CHOICE_TEXT);
        }
    }

    // Show logged-in header
    private void showLoggedInHeader() {
        // Clear the screan
        clearScreen();  
        // Info we need
        String username = this.app.getCurrentUser().getUsername();
        String teamName = this.app.getCurrentUser().getTeam().getTeamName();
        Double balance = this.app.getCurrentUser().getTeam().getBudget().getCurrentAmount();
        String stringBalance = Double.toString(balance);
        // Populate menu header
        System.out.println(DELIMITOR_LINE);
        printInfoLine(PRODUCT_NAME, 68);
        System.out.println(BLANK_LINE); 
        printInfoLine("Username:               " + username, 68);
        printInfoLine("Team:                   " + teamName, 68);
        printInfoLine("Remaining Team Balance: " + stringBalance, 68);
        System.out.println(DELIMITOR_LINE);
    }
    
    // Create the Logged-In menu
    private void createLoggedInMenu() throws NumberFormatException, ParseException, IOException {
        // Show header
        this.showLoggedInHeader();
        // Info we need
        List<Expense> expenses = this.app.getCurrentUser().getTeam().getBudget().getExpenses();
        String username = this.app.getCurrentUser().getUsername();
        // Show Team Expenses
        for (Expense expense : expenses) {
            String stringAmount = Double.toString(expense.getAmount());
            String description = expense.getDescription();
            String stringDate = expense.getDateAsString();
            System.out.print(START_TEXT_LINE + padString(stringAmount, 17) + padString(description, 17) + padString(stringDate, 17) + padString(username, 17) + END_TEXT_LINE +"\n");

        }
        System.out.println(DELIMITOR_LINE);
        printInfoLine("Where would you like to go?", 68);
        System.out.println(DELIMITOR_LINE);
        printInfoLine("1. Create Expense", 68);
        printInfoLine("2. Create New User", 68);
        printInfoLine("3. Change Password", 68);
        printInfoLine("4. Help Guide", 68);
        printInfoLine("5. Log out", 68);
        System.out.println(DELIMITOR_LINE + "\n");

        do{
            int userChoice = this.app.takeUserChoice();

            switch (userChoice) {
                case 1: this.createCreateExpenseMenu();
                        break;
                case 2: this.createCreateNewUserMenu();
                        break;
                case 3: this.createChangePasswordMenu();
                        break;
                case 4: this.createHelpGuideMenu("LoggedIn");
                        break;
                // We will reset the app state with this choice
                // Logging-out will write CSV data back to files
                case 5: this.app.resetCurrentUser();
                        this.app.writeBackToFiles();
                        this.createHomeMenu();
                        break;
                default: System.out.println(INVALID_CHOICE_TEXT);
            }
        }
        while (!validChoice);
    }
    
    // Create the Expense menu
    private void createCreateExpenseMenu() throws NumberFormatException, ParseException, IOException {
        // Show the header
        this.showLoggedInHeader();
        // Info we need
        User user = this.app.getCurrentUser();
        // Ask for the expense details
        String expenseAmount = this.app.takeUserInput("Enter expense amount: ");
        String expenseDescription = this.app.takeUserInput("Enter expense description: ");
        String expenseDate = this.app.takeUserInput("Enter expense date: ");
        // Make the expense instance
        Expense expense = new Expense(Double.valueOf(expenseAmount), expenseDescription, expenseDate, user);
        // Record the expense against the team's budget
        this.app.getCurrentUser().getTeam().getBudget().recordExpense(expense);
        // Add the expense to the Application's list
        this.app.addExpense(expense);
        // Go back to Logged-in menu
        this.createLoggedInMenu();
    }

    // Create the New User menu
    private void createCreateNewUserMenu() throws NumberFormatException, ParseException, IOException {
        // Show the header
        this.showLoggedInHeader();
        // Info we need
        Team team = this.app.getCurrentUser().getTeam();
        // Ask for the user details
        String newUsername = this.app.takeUserInput("Enter the new user's username: ");
        String newPassword = this.app.takeUserInput("Enter the new user's initial password: ");
        // Make the new User instance
        User newUser = new User(newUsername, newPassword, team);
        // Add the user to the Application's list
        this.app.addUser(newUser);
        // Go back to Logged-in menu
        this.createLoggedInMenu();
    }

    // Create the Change Password menu
    private void createChangePasswordMenu() throws NumberFormatException, ParseException, IOException {
        // Show the header
        this.showLoggedInHeader();
        // Info we need
        User user = this.app.getCurrentUser();
        // Ask for the new password
        while (true) {
            String newPassword = this.app.takeUserInput("Enter new password: ");
            String confirmPassword = this.app.takeUserInput("Confirm new password: ");
            if (newPassword.equals(confirmPassword)) {
                user.setPassword(newPassword);
                break;
            } else {
                System.out.println("Passwords did not match!");
            }
        }
        // Go back to Logged-in menu
        this.createLoggedInMenu();
    }
}
