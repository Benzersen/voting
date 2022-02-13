package com.corpfield.votingRegistration.repo;

import com.corpfield.votingRegistration.entity.Voters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotersRepo extends JpaRepository<Voters,Long> {
}
