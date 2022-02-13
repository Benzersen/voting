package com.corpfield.votingRegistration.dto;

import lombok.Data;

@Data
public class VotersListResDto {
    private long voterId;
    private String fullName;
    private String Address;
    private long partyId;
    private String partyName;

}
