package com.corpfield.votingRegistration.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "voters")
public class Voters {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "voter_id")
        private long voterId;

        @NotNull
        @Column(name = "full_name")
        private String fullName;

        @NotNull
        @Column(name = "address")
        private String address;

        @ManyToOne
        @JoinColumn(name = "party_id")
        private Parties parties;
    }

