package expense_system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Team {

    // fields
    private String teamName;
    private Budget budget;
    private List<User> users;
    public static List<String> teamRow = new ArrayList<String>();
    public static List<Double> budgetRow = new ArrayList<Double>();
    public static List<Team> teams = new ArrayList<Team>();

    // constructor
    public Team(String name, double budget) {
        this.teamName = name;
        this.budget = new Budget(budget);
        
    }

    // methods
    public void addUser(User user) {
        this.users.add(user);
        //user.setTeam(this);
    }

    public String getTeamName() {
        return this.teamName;
    }

    public static String getTeamBudget(String team) {
        for (int i = 0; i < teamRow.size(); i++) {
            if (team.equals(teamRow.get(i))) {
                return budgetRow.get(i).toString();
                
            }
        }
        return "Not Found";
    }

    public List<User> getUsers() {
        return this.users;
    }

    public String toString() {
        return this.teamName;
    }

    public static void scanExpensesCSV() throws NumberFormatException, ParseException {
        String filepath = "Teams.csv";
        BufferedReader reader = null;
        String line = "";
        

        try {
            reader = new BufferedReader(new FileReader(filepath));
            while((line = reader.readLine()) != null) {
                //System.out.println(line);
                String[] row = line.split(",");
                teamRow.add(row[0]);
                budgetRow.add(Double.valueOf(row[1]));
                

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
        
        for (int i = 2; i < teamRow.size(); i++) {

            Team newTeam = new Team(teamRow.get(i), Double.valueOf(budgetRow.get(i)));
            teams.add(newTeam);
        }
        
    }
}