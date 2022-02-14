package com.corpfield.votingRegistration.service;

import com.corpfield.votingRegistration.dto.VotersCreateReqDto;
import com.corpfield.votingRegistration.dto.VotersEditReqDto;
import com.corpfield.votingRegistration.dto.VotersListResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VotersService {
    public void createvoter(VotersCreateReqDto reqDto);

    public void editvoter(VotersEditReqDto reqDto);

    public Page<VotersListResDto> listvotersbypage(Pageable pageable);

    public Page<VotersListResDto> listvotersbypage(Pageable pageable,long partyId);
}
