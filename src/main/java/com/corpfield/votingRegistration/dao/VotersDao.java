package com.corpfield.votingRegistration.dao;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VotersDao {
    public List<Object[]> getvoterswithpage(Pageable pageable);

    public List<Object[]> getvoterswithpage(Pageable pageable,long partyId);

    public int getTotalvoters();

    public int getTotalvoters(long partyId);
}
