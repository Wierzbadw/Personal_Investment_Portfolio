package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Stocks;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class StocksDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Stocks stocks){
        entityManager.persist(stocks);
    }

    public Stocks merge(Stocks stocks){
        return entityManager.merge(stocks);
    }

    public Stocks findById(Long id){
        return entityManager.find(Stocks.class, id);
    }

    public void remove(Stocks stocks) {
        entityManager.remove(entityManager.contains(stocks) ? stocks : entityManager.merge(stocks));
    }

    public List<Stocks> findAll() {
        Query query = entityManager.createQuery("SELECT a from Stocks a");
        return query.getResultList();
    }


}
