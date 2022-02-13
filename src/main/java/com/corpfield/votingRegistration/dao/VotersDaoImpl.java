package com.corpfield.votingRegistration.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Component
public class VotersDaoImpl implements VotersDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Object[]> getvoterswithpage(Pageable pageable) {
        String myquery = "select  " +
                "voters.voter_id, " +
                "voters.full_name, " +
                "voters.address, " +
                "parties.party_id, " +
                "parties.party_name " +
                "from voters " +
                "inner join parties on parties.party_id=voters.party_id";
        Query query = em.createNativeQuery(myquery);
        query.setFirstResult(pageable.getPageNumber()* pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        return query.getResultList();
    }

    @Override
    public int getTotalvoters() {
        String myquery = "select " +
                "count(*) " +
                "     from voters ";
        Query query = em.createNativeQuery(myquery);
        String result=String.valueOf(query.getSingleResult());
        return Integer.parseInt(result);
    }
}
