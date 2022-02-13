package com.corpfield.votingRegistration.dao;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PartiesDao {
    public List<Object[]> getPartiesWith(Pageable myPageable);

    int getTotalParties();
}
