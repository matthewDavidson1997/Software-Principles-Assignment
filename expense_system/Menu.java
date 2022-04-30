package expense_system;

import java.util.List;

public class Menu {
    
    boolean validChoice = false;

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public void showHomeMenu(){
        this.createHomeMenu();
    }

    public void showLoginMenu(){
        this.createLoginMenu();
    }

    public void createHomeMenu(){
        clearScreen();
        System.out.println(" -------------------------------------------------------");
        System.out.println("|  feel good fund management system                     |");
        System.out.println("|                                                       |"); 
        System.out.println("|  Where would you like to go?                          |");
        System.out.println(" -------------------------------------------------------");
        System.out.println("|  1. Login                                             |"); 
        System.out.println("|  2. About                                             |"); 
        System.out.println("|  3. Help Guide                                        |"); 
        System.out.println(" -------------------------------------------------------\n");
        do{
            Application app = new Application();
            int userChoice = app.takeUserChoice();

            switch (userChoice) {
                case 1: createLoginMenu();
                        break;
                case 2: createAboutMenu();
                        break;
                case 3: System.out.println("Help Guide selected");
                        break;
                default: System.out.println("Invalid choice");
            }
        }
        while (validChoice == false);
    }

    public void createLoginMenu(){
        clearScreen();
        System.out.println(" -------------------------------------------------------");
        System.out.println("|  feel good fund system                                |");
        System.out.println("|                                                       |"); 
        System.out.println("|  Please enter your username and password to continue  |");
        System.out.println(" -------------------------------------------------------\n\n");
        Application app = new Application();
        app.takeUserCredentials();
        createLoggedInMenu();
    }

    public void createAboutMenu(){
        clearScreen();
        System.out.println(" -------------------------------------------------------");
        System.out.println("|  feel good fund system                                |");
        System.out.println("|                                                       |"); 
        System.out.println("|  Redgate has always looked after its employees.       |");
        System.out.println("|  As such a 'Feel Good Fund' was established which     |");
        System.out.println("|  is money set aside for each team to do social        |");
        System.out.println("|  activities together and reclaim their expenses.      |");
        System.out.println("|                                                       |");
        System.out.println("|  This platform allows each team to track their        |");
        System.out.println("|  budget, seeing remaining budget, track expenses,     |");
        System.out.println("|  and submitting new expenses.                         |");
        System.out.println("|                                                       |");
        System.out.println("|  It does not act as a replacement to the usual        |");
        System.out.println("|  process of expenses to claim back money spent.       |");
        System.out.println(" -------------------------------------------------------");
        System.out.println("|  Where would you like to go?                          |");
        System.out.println(" -------------------------------------------------------");
        System.out.println("|  1. Home                                              |"); 
        System.out.println(" -------------------------------------------------------\n");
        Application app = new Application();
        int userChoice = app.takeUserChoice();
        switch (userChoice) {
            case 1: createHomeMenu();
                break;
            default: System.out.println("Invalid choice");
        }
    }
    
    public void createLoggedInMenu() {
        clearScreen();
        Application app = new Application();
        Budget budget = team1.getBudget();
        User currentUser = app.getCurrentUser();
        String currentUserTeam = app.findTeam(currentUser);
        
        System.out.println(" -------------------------------------------------------");
        System.out.println("|  feel good fund system                                |");
        System.out.println("|                                                       |"); 
        System.out.println(   "|  Username:               " + currentUser + "          |");
        System.out.println(   "|  Team:                   " + currentUserTeam + "      |");
        System.out.println(   "|  Remaining Team Balance: " + budget + "               |");
        System.out.println(" -------------------------------------------------------");

            // for i in expenses print i

        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        System.out.println(" -------------------------------------------------------");
        System.out.println("|  Where would you like to go?                          |");
        System.out.println(" -------------------------------------------------------");
        System.out.println("|  1. Enter Expense                                     |"); 
        System.out.println("|  2. Help Guide                                        |");
        System.out.println("|  3. Options                                           |");
        System.out.println("|  4. Log out                                           |");
        System.out.println(" -------------------------------------------------------\n");
        int userChoice = app.takeUserChoice();
    }
 
}
