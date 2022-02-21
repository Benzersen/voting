package com.corpfield.votingRegistration.dto;

import com.corpfield.votingRegistration.entity.Voters;
import lombok.Data;

@Data
public class VotersEditReqDto {
    private long voterId;
    private String fullName;
    private String Address;
    private long partyId;

    public Voters convertDtoToEntity(Voters voter) {
        voter.setFullName(this.fullName);
        voter.setAddress(this.Address);
        return voter;
    }
}
