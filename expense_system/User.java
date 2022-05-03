package expense_system;
import java.io.*;
import java.util.*;


public class User {

    // fields
    public static String userName;
    public static String password;
    public static Team team;
    public static List<String> usernameRow = new ArrayList<String>();
    public static List<String> passwordRow = new ArrayList<String>();
    public static List<String> teamRow = new ArrayList<String>();
    public static List<User> users = new ArrayList<User>();
    

    // constructor
    public User(String userName, String password, String team) {
        this.userName = userName;
        this.password = password;
        this.team = new Team(team, 0.0);
    }

    // methods
    public String toString() {
        return this.userName;
    }

    public static String getUserTeam(String user) {
        for (int i = 0; i < usernameRow.size(); i++) {
            if (user.equals(usernameRow.get(i))) {
                return teamRow.get(i);
            }
            else {
                System.out.println("Team not found.")
            }
        }
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.userName; 
    }

    public static void scanUsersCSV() {
        String filepath = "Users.csv";
        BufferedReader reader = null;
        String line = "";
        

        try {
            reader = new BufferedReader(new FileReader(filepath));
            while((line = reader.readLine()) != null) {
                //System.out.println(line);
                String[] row = line.split(",");
                usernameRow.add(row[0]);
                passwordRow.add(row[1]);
                teamRow.add(row[2]);
                
                for(String index : row) {
                    //System.out.printf("%-10s", index);
                    //System.out.println(row[0]);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // add users to list while constructing
        
        for (int i = 1; i < usernameRow.size(); i++) {

            User newUser = new User(usernameRow.get(i), passwordRow.get(i), teamRow.get(i));
            users.add(newUser);
        }
       
    }

 

}