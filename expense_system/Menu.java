package expense_system;
import java.io.*;
import java.text.ParseException;
import java.util.*;


public class Menu {
    
    boolean validChoice = false;

    String deliminatorLine = " ---------------------------------------------------------------------";
    String blankLine = "|                                                                     |";
    String startTextLine = "| ";
    String endTextLine = "|";
    Application app = new Application();

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public void showHomeMenu() throws NumberFormatException, ParseException{
        this.createHomeMenu();
    }

    public void showLoginMenu() throws NumberFormatException, ParseException{
        this.createLoginMenu();
    }

    public String padString(String string, int n){
        return String.format("%-" + n + "s", string);
        
    }

    public void createHomeMenu() throws NumberFormatException, ParseException{
        clearScreen();
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("feel good fund management system", 68) + endTextLine);
        System.out.println(blankLine); 
        System.out.println(startTextLine + padString("Where would you like to go?", 68) + endTextLine);
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("1. Login", 68) + endTextLine); 
        System.out.println(startTextLine + padString("2. About", 68) + endTextLine); 
        System.out.println(startTextLine + padString("3. Help Guide", 68) + endTextLine); 
        System.out.println(deliminatorLine + "\n");
        
        
        do{
            
            int userChoice = app.takeUserChoice();

            switch (userChoice) {
                case 1: createLoginMenu();
                        break;
                case 2: createAboutMenu();
                        break;
                case 3: createHelpGuideMenu("Home");
                        break;
                default: System.out.println("Invalid choice");
            }
        }
        while (!validChoice);
    }

    public void createLoginMenu() throws NumberFormatException, ParseException{
        clearScreen();
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("feel good fund system", 68) + endTextLine);
        System.out.println(blankLine); 
        System.out.println(startTextLine + padString("Please enter your username and password to continue", 68) + endTextLine);
        System.out.println(deliminatorLine + "\n");
        
        app.takeUserCredentials();
        createLoggedInMenu();
    }

    public void createAboutMenu() throws NumberFormatException, ParseException{
        clearScreen();
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("feel good fund system", 68) + endTextLine);
        System.out.println(blankLine); 
        System.out.println(startTextLine + padString("Redgate has always looked after its employees.", 68) + endTextLine);
        System.out.println(startTextLine + padString("As such a 'Feel Good Fund' was established which", 68) + endTextLine);
        System.out.println(startTextLine + padString("is money set aside for each team to do social", 68) + endTextLine);
        System.out.println(startTextLine + padString("activities together and reclaim their expenses.", 68) + endTextLine);
        System.out.println(blankLine);
        System.out.println(startTextLine + padString("This platform allows each team to track their", 68) + endTextLine);
        System.out.println(startTextLine + padString("budget, seeing remaining budget, track expenses,", 68) + endTextLine);
        System.out.println(startTextLine + padString("and submitting new expenses.", 68) + endTextLine);
        System.out.println(blankLine);
        System.out.println(startTextLine + padString("It does not act as a replacement to the usual", 68) + endTextLine);
        System.out.println(startTextLine + padString("process of expenses to claim back money spent.", 68) + endTextLine);
        System.out.println(deliminatorLine);
        System.out.println(startTextLine  + padString("Where would you like to go?", 68) + endTextLine);
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("1. Home", 68) + endTextLine); 
        System.out.println(deliminatorLine + "\n");
        
        int userChoice = app.takeUserChoice();
        switch (userChoice) {
            case 1: createHomeMenu();
                break;
            default: System.out.println("Invalid choice");
        }
    }

    public void createHelpGuideMenu(String goBackTo) throws NumberFormatException, ParseException{
        clearScreen();
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("feel good fund system", 68) + endTextLine);
        System.out.println(blankLine);
        System.out.println(startTextLine + padString("This application allows you to view and enter", 68) + endTextLine);
        System.out.println(startTextLine + padString("expenses associated with the feel good fund", 68) + endTextLine);
        System.out.println(startTextLine + padString("to keep track of your team's budget.", 68) + endTextLine);
        System.out.println(blankLine);
        System.out.println(startTextLine + padString("If you are having difficulty logging in", 68) + endTextLine);
        System.out.println(startTextLine + padString("please contact your system admin.", 68) + endTextLine);
        System.out.println(deliminatorLine);
        System.out.println(startTextLine  + padString("Where would you like to go?", 68) + endTextLine);
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("1. " + goBackTo, 68) + endTextLine); 
        System.out.println(deliminatorLine + "\n");
        
        int userChoice = app.takeUserChoice();
        switch (userChoice) {
            case 1: if (goBackTo.equals("Home")) {
                createHomeMenu();
                } else {
                    createLoggedInMenu();
                }
                break;
            default: System.out.println("Invalid choice");
        }
    }

    public void createLoggedInMenu() throws NumberFormatException, ParseException {
        clearScreen();
        //Budget budget = team1.getBudget();
        //User currentUser = app.getCurrentUser();
        //String currentUserTeam = app.findTeam(currentUser);
        
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("feel good fund system", 68) + endTextLine);
        System.out.println(blankLine); 
        System.out.println(startTextLine + "Username:               " + padString(Application.currentUser, 44) + endTextLine);
        System.out.println(startTextLine + "Team:                   " + padString(User.getUserTeam(Application.currentUser), 44) + endTextLine);
        System.out.println(startTextLine + "Remaining Team Balance: " + padString("", 44) + endTextLine);
        System.out.println(deliminatorLine);

            // for i in expenses print i
        for (int i = 1; i < Expense.amountRow.size(); i++) {
            System.out.print(startTextLine + padString(Expense.amountRow.get(i), 17) + padString(Expense.descriptionRow.get(i), 17) + padString(Expense.dateRow.get(i), 17) + padString(Expense.userRow.get(i), 17) + endTextLine +"\n");
        }
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("Where would you like to go?", 68) + endTextLine);
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("1. Create Expense", 68) + endTextLine); 
        System.out.println(startTextLine + padString("2. Help Guide", 68) + endTextLine);
        System.out.println(startTextLine + padString("3. Options", 68) + endTextLine);
        System.out.println(startTextLine + padString("4. Log out", 68) + endTextLine);
        System.out.println(deliminatorLine + "\n");
        do{
            int userChoice = app.takeUserChoice();

            switch (userChoice) {
                case 1: createCreateExpenseMenu();
                        break;
                case 2: createHelpGuideMenu("View Expenses");
                        break;
                case 3: System.out.println("Options selected");
                        break;
                case 4: createHomeMenu();
                default: System.out.println("Invalid choice");
            }
        }
        while (!validChoice);
    }
   
    public void createCreateExpenseMenu() throws NumberFormatException, ParseException {
        clearScreen();        
        
        System.out.println(deliminatorLine);
        System.out.println(startTextLine + padString("feel good fund system", 68) + endTextLine);
        System.out.println(blankLine); 
        System.out.println(startTextLine + "Username:               " + padString(Application.currentUser, 44) + endTextLine);
        System.out.println(startTextLine + "Team:                   " + padString("", 44) + endTextLine);
        System.out.println(startTextLine + "Remaining Team Balance: " +padString("", 44) + endTextLine);
        System.out.println(deliminatorLine);

        String expenseAmount = app.takeUserInput("Enter expense amount: ");
        String expenseDescription = app.takeUserInput("Enter expense description: ");
        String expenseDate = app.takeUserInput("Enter expense date: ");
        String expenseUser = Application.currentUser;

        Expense newExpense = new Expense(Double.valueOf(expenseAmount), expenseDescription, expenseDate, expenseUser);
        Expense.expenses.add(newExpense);
        Expense.amountRow.add(expenseAmount);
        Expense.descriptionRow.add(expenseDescription);
        Expense.dateRow.add(expenseDate);
        Expense.userRow.add(expenseUser);

        createLoggedInMenu();

    }
    
 
}
