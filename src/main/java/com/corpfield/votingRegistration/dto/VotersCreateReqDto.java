package com.corpfield.votingRegistration.dto;

import lombok.Data;

@Data
public class VotersCreateReqDto {
    private long partyId;
    private String fullName;
    private String Address;
}
