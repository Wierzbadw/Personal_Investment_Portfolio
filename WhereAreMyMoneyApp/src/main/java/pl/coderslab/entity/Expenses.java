package pl.coderslab.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2, max = 20, message = "Nazwa musi mieć od 2 do 20 znaków")
    private String expenseName;

    private String category;


    private double expenseAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", expenseName='" + expenseName + '\'' +
                ", category=" + category +
                ", expenseAmount=" + expenseAmount +
                '}';
    }
}
