package com.corpfield.votingRegistration.service;

import com.corpfield.votingRegistration.dto.VotersCreateReqDto;
import com.corpfield.votingRegistration.dto.VotersEditReqDto;
import com.corpfield.votingRegistration.dto.VotersListResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VotersService {
    public void createVoter(VotersCreateReqDto reqDto);

    public void editVoter(VotersEditReqDto reqDto);

    public Page<VotersListResDto> listVotersByPage(Pageable pageable);
}
