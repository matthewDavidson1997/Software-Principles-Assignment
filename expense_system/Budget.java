package expense_system;

import java.util.ArrayList;
import java.util.List;

/**
 * The Budget class records the current status of a Team's budget - recording the initial amount,
 * and details of recorded expenses that users make.
 */
public class Budget {

    // FIELDS
    private double startingAmount;
    private double currentAmount;
    private List<Expense> expenses = new ArrayList<>();

    // CONSTRUCTOR
    public Budget(double startingAmount) {
        this.startingAmount = startingAmount;
        this.currentAmount = startingAmount;
    }

    // METHODS

    // to string
    public String toString() {
        return this.startingAmount + " (current = " + this.currentAmount + ")";
    }

    // getters
    public double getCurrentAmount() {
        return this.currentAmount;
    }
    public List<Expense> getExpenses() {
        return this.expenses;
    }

    // other methods

    // A method to return expenses relating to a particular user
    public List<Expense> getUserExpenses(User user) {
        List<Expense> userExpenses = new ArrayList<>();
        for (Expense expense : this.expenses) {
            if (expense.getUser() == user) {
                userExpenses.add(expense);
            }
        }
        return userExpenses;
    }

    // A method to add funds to the budget (we don't keep a history of these events)
    public void addFunds(double amount) {
        this.currentAmount += amount;
    }

    // A method to record an expense against the budget
    public void recordExpense(Expense expense) {
        this.currentAmount -= expense.getAmount();
        this.expenses.add(expense);
    }

    // A simple method to print all expenses
    public void printExpenses() {
        for (Expense expense : this.expenses) {
            System.out.println(expense);
        }
    }
}
