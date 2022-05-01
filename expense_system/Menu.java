package expense_system;
import java.io.*;
import java.util.*;


public class Menu {
    
    boolean validChoice = false;

    String deliminatorLine = " ------------------------------------------------------";
    String blankLine = "|                                                      |";
    String startTextLine = "| ";
    String endTextLine = "|";

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

    public String padString(String string, int n){
        return String.format("%-" + n + "s", string);
        
    }

    public void createHomeMenu(){
        clearScreen();
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("feel good fund management system", 53) + endTextLine);
        System.out.println(blankLine); 
        System.out.println(startTextLine + padString("Where would you like to go?", 53) + endTextLine);
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("1. Login", 53) + endTextLine); 
        System.out.println(startTextLine + padString("2. About", 53) + endTextLine); 
        System.out.println(startTextLine + padString("3. Help Guide", 53) + endTextLine); 
        System.out.println(deliminatorLine + "\n");
        User.scanUsersCSV();
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
        while (!validChoice);
    }

    public void createLoginMenu(){
        clearScreen();
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("feel good fund system", 53) + endTextLine);
        System.out.println(blankLine); 
        System.out.println(startTextLine + padString("Please enter your username and password to continue", 53) + endTextLine);
        System.out.println(deliminatorLine + "\n");
        Application app = new Application();
        app.takeUserCredentials();
        createLoggedInMenu();
    }

    public void createAboutMenu(){
        clearScreen();
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("feel good fund system", 53) + endTextLine);
        System.out.println(blankLine); 
        System.out.println(startTextLine + padString("Redgate has always looked after its employees.", 53) + endTextLine);
        System.out.println(startTextLine + padString("As such a 'Feel Good Fund' was established which", 53) + endTextLine);
        System.out.println(startTextLine + padString("is money set aside for each team to do social", 53) + endTextLine);
        System.out.println(startTextLine + padString("activities together and reclaim their expenses.", 53) + endTextLine);
        System.out.println(blankLine);
        System.out.println(startTextLine + padString("This platform allows each team to track their", 53) + endTextLine);
        System.out.println(startTextLine + padString("budget, seeing remaining budget, track expenses,", 53) + endTextLine);
        System.out.println(startTextLine + padString("and submitting new expenses.", 53) + endTextLine);
        System.out.println(blankLine);
        System.out.println(startTextLine + padString("It does not act as a replacement to the usual", 53) + endTextLine);
        System.out.println(startTextLine + padString("process of expenses to claim back money spent.", 53) + endTextLine);
        System.out.println(deliminatorLine);
        System.out.println(startTextLine  + padString("Where would you like to go?", 53) + endTextLine);
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("1. Home", 53) + endTextLine); 
        System.out.println(deliminatorLine + "\n");
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
        //Budget budget = team1.getBudget();
        //User currentUser = app.getCurrentUser();
        //String currentUserTeam = app.findTeam(currentUser);
        
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("feel good fund system", 53) + endTextLine);
        System.out.println(blankLine); 
        System.out.println(startTextLine + "Username:               " + padString(app.currentUser, 29) + endTextLine);
        System.out.println(startTextLine + "Team:                   " + padString("", 29) + endTextLine);
        System.out.println(startTextLine + "Remaining Team Balance: " +padString("", 29) + endTextLine);
        System.out.println(deliminatorLine);

            // for i in expenses print i

        System.out.println(startTextLine + padString("", 53) + endTextLine);
        System.out.println(startTextLine + padString("", 53) + endTextLine);
        System.out.println(startTextLine + padString("", 53) + endTextLine);
        System.out.println(startTextLine + padString("", 53) + endTextLine);
        System.out.println(startTextLine + padString("", 53) + endTextLine);
        System.out.println(startTextLine + padString("", 53) + endTextLine);
        System.out.println(startTextLine + padString("", 53) + endTextLine);
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("Where would you like to go?", 53) + endTextLine);
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("1. Create Expense", 53) + endTextLine); 
        System.out.println(startTextLine + padString("2. Help Guide", 53) + endTextLine);
        System.out.println(startTextLine + padString("3. Options", 53) + endTextLine);
        System.out.println(startTextLine + padString("4. Log out", 53) + endTextLine);
        System.out.println(deliminatorLine + "\n");
        do{
            int userChoice = app.takeUserChoice();

            switch (userChoice) {
                case 1: System.out.println("Create Expense selected");
                        break;
                case 2: System.out.println("Help Guide selected");
                        break;
                case 3: System.out.println("Options selected");
                        break;
                case 4: createHomeMenu();
                default: System.out.println("Invalid choice");
            }
        }
        while (!validChoice);
    }

    
 
}
