package expense_system;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Menu {
    public boolean userValidated = false;
    
    public void showLoginMenu(){
        this.createLoginMenu();
    }

    public void createLoginMenu(){
        
        System.out.println(" -------------------------------------------------------");
        System.out.println("|         Welcome to the feel good fund system          |");
        System.out.println("|                                                       |"); 
        System.out.println("|  Please enter your username and password to continue  |");
        System.out.println(" -------------------------------------------------------\n\n");
        takeUserCredentials();
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
            userValidated = true;
        } else {
            System.out.println("Login unsuccessful, please enter valid credentials.");
            userValidated = false;
        }
    }
    
}
