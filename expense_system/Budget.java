package expense_system;

import java.util.ArrayList;
import java.util.List;

public class Budget {

    // fields
    private double startingAmount;
    private double currentAmount;
    private List<Expense> expenses;

    // constructor
    public Budget(double startingAmount) {
        this.startingAmount = startingAmount;
        this.currentAmount = startingAmount;
        this.expenses = new ArrayList<>();
    }

    // methods
    public void addFunds(double amount) {
        this.currentAmount += amount;
    }

    public void recordExpense(Expense expense) {
        this.currentAmount -= expense.getAmount();
        this.expenses.add(expense);
    }

    public double getCurrentAmount() {
        return this.currentAmount;
    }

    public List<Expense> getExpenses() {
        return this.expenses;
    }

    public void printExpenses() {
        for(int i = 0; i < this.expenses.size(); i++) {
            System.out.println(this.expenses.get(i));
        }
    }

    public String toString() {
        return this.startingAmount + " (current = " + this.currentAmount + ")";
    }
}
