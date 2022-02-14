package com.corpfield.votingRegistration.service;

import com.corpfield.votingRegistration.dto.ResponseDto;
import com.corpfield.votingRegistration.dto.VotersCreateReqDto;
import com.corpfield.votingRegistration.dto.VotersEditReqDto;
import com.corpfield.votingRegistration.dto.VotersListResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VotersService {
    public ResponseDto createVoter(VotersCreateReqDto reqDto);

    public ResponseDto editVoter(VotersEditReqDto reqDto);

    public ResponseDto listVotersByPage(Pageable pageable);

    public ResponseDto listVotersByPage(Pageable pageable, long partyId);
}
