package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Expenses;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ExpensesDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Expenses expenses){
        entityManager.persist(expenses);
    }

    public Expenses merge(Expenses expenses){
       return entityManager.merge(expenses);
    }

    public Expenses findById(Long id){
        return entityManager.find(Expenses.class, id);
    }
    public void remove(Expenses expenses) {
        entityManager.remove(entityManager.contains(expenses) ? expenses : entityManager.merge(expenses));
    }

    public List<Expenses> findAll() {
        Query query = entityManager.createQuery("SELECT a from Expenses a");
        return query.getResultList();
    }

    public List<Expenses> findAllByMonth(String month) {
        Query query = entityManager.createQuery("select e from Expenses e where e.date = '%:month%' ");
        return query.getResultList();
    }

    public double expensesTotalValue(List<Expenses> listExpenses){
        double totalValue = 0;
        for (int i=0; i< listExpenses.size(); i++)
        {
            totalValue += listExpenses.get(i).getExpenseAmount();
        }
        return  totalValue;

    }

    public double foodValueTotal(List<Expenses> listExpenses){
        double foodValue = 0;
        for (int i=0; i< listExpenses.size(); i++)
        {
            if(listExpenses.get(i).getExpenseName() == "Food") {
                foodValue += listExpenses.get(i).getExpenseAmount();
            }
        }
        return  foodValue;
    }
}
