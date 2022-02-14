package com.corpfield.votingRegistration.service;

import com.corpfield.votingRegistration.dto.CreatePartyReqDto;
import com.corpfield.votingRegistration.dto.EditPartyReqDto;
import com.corpfield.votingRegistration.dto.PartyListResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PartyService {

    public void createParty(CreatePartyReqDto partyReqDto);

    void editPartyDetail(EditPartyReqDto reqDto);

    Page<PartyListResDto> ListPartyDetails(Pageable pageable);


}
