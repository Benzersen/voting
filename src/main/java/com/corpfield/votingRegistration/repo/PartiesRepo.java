package com.corpfield.votingRegistration.repo;

import com.corpfield.votingRegistration.entity.Parties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartiesRepo extends JpaRepository <Parties,Long> {

}
