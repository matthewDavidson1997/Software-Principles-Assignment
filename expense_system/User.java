package expense_system;

public class User {

    // fields
    private String userName;
    private String password;
    private Team team;

    // constructor
    public User(String userName) {
        this.userName = userName;
    }

    // methods
    public String toString() {
        return this.userName;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return this.team;
    }
    /*
    public static void main(String[] args) {
        Team team1 = new Team("Team 1", 1066.0);
        User user1 = new User("Joe Bloggs");
        team1.addUser(user1);
        System.out.println(user1.getTeam());
        System.out.println(user1.getTeam().getBudget());
    }
    */

}