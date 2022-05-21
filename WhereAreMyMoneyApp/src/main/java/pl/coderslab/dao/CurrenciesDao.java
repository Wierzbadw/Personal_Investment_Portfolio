package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Currencies;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CurrenciesDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Currencies currencies ){
        entityManager.persist(currencies);
    }

    public Currencies merge(Currencies currencies){
        return entityManager.merge(currencies);
    }

    public Currencies findById(Long id){
        return entityManager.find(Currencies.class, id);
    }
    public void remove(Currencies currencies) {
        entityManager.remove(entityManager.contains(currencies) ? currencies : entityManager.merge(currencies));
    }

    public List<Currencies> findAll() {
        Query query = entityManager.createQuery("SELECT a from Currencies a");
        return query.getResultList();
    }

    public double currencyValueTotal(List<Currencies> listCurrencies){
        double totalValue = 0;
        for (int i=0; i< listCurrencies.size(); i++)
        {
           totalValue += listCurrencies.get(i).getCurrencyRate()*listCurrencies.get(i).getCurrencyAmount();
        }
        return  totalValue;

    }



}

