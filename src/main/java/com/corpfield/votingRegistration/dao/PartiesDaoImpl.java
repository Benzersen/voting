package com.corpfield.votingRegistration.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Component
public class PartiesDaoImpl implements PartiesDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Object[]> getPartiesWith(Pageable myPageable) {
        String myQuery = "SELECT " +
                "parties.party_id, " +
                "parties.party_name " +
                "FROM parties ";
        Query query = entityManager.createNativeQuery(myQuery);
        query.setFirstResult(myPageable.getPageNumber() * myPageable.getPageSize());
        query.setMaxResults(myPageable.getPageSize());
        return query.getResultList();
    }

    @Override
    public int getTotalParties() {
        String myQuery = "SELECT " +
                "count(*) " +
                "FROM parties ";
        Query query = entityManager.createNativeQuery(myQuery);
        String result = String.valueOf(query.getSingleResult());
        return Integer.parseInt(result);
    }
}
