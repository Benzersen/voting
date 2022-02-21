package com.corpfield.votingRegistration.dto;

import com.corpfield.votingRegistration.entity.Voters;
import lombok.Data;

@Data
public class VotersCreateReqDto {
    private long partyId;
    private String fullName;
    private String Address;


    public Voters convertDtoToEntity() {
        Voters voter = new Voters();
        voter.setFullName(this.fullName);
        voter.setAddress(this.Address);
        return voter;
    }
}
