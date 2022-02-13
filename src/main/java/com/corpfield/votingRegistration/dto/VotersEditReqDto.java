package com.corpfield.votingRegistration.dto;

import lombok.Data;

@Data
public class VotersEditReqDto {
    private long voterId;
    private String fullName;
    private String Address;
    private long partyId;
}
