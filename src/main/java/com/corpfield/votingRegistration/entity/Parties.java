package com.corpfield.votingRegistration.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="parties")
public class Parties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private long partyId;

    @NotNull
    @Column(name = "party_name")
    private String partyName;

}
