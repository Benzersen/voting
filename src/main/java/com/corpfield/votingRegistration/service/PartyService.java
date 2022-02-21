package com.corpfield.votingRegistration.service;

import com.corpfield.votingRegistration.dto.CreatePartyReqDto;
import com.corpfield.votingRegistration.dto.EditPartyReqDto;
import com.corpfield.votingRegistration.dto.PartyListResDto;
import com.corpfield.votingRegistration.dto.ResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PartyService {

    public ResponseDto createParty(CreatePartyReqDto partyReqDto);

    public ResponseDto editPartyDetail(EditPartyReqDto reqDto);

    public ResponseDto ListPartyDetails(Pageable pageable);

}
