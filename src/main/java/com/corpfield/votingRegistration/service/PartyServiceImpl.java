package com.corpfield.votingRegistration.service;

import com.corpfield.votingRegistration.dao.PartiesDao;
import com.corpfield.votingRegistration.dto.CreatePartyReqDto;
import com.corpfield.votingRegistration.dto.EditPartyReqDto;
import com.corpfield.votingRegistration.dto.PartyListResDto;
import com.corpfield.votingRegistration.entity.Parties;
import com.corpfield.votingRegistration.repo.PartiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static com.corpfield.votingRegistration.utils.QueryUtils.convertObjToLong;
import static com.corpfield.votingRegistration.utils.QueryUtils.convertObjToString;


@Service
public class PartyServiceImpl implements PartyService {

    @Autowired
    PartiesRepo myPartyRepo;

    @Autowired
    PartiesDao partiesDao;

    @Override
    public void createParty(CreatePartyReqDto partyReqDto) {
        try {
            Parties party = new Parties();
            party.setPartyName(partyReqDto.getPartyName());
            myPartyRepo.save(party);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editPartyDetail(EditPartyReqDto reqDto) {
        try {
            Optional<Parties> optionalParty =myPartyRepo.findById(reqDto.getPartyId());
            if (optionalParty.isPresent()) {
                Parties party = optionalParty.get();
                party.setPartyName(reqDto.getPartyName());
                myPartyRepo.save(party);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Page<PartyListResDto> ListPartyDetails(Pageable pageable) {
        try {
            List<Object[]> queryResult = partiesDao.getPartiesWith(pageable);
            int totalParties = partiesDao.getTotalParties();
            List<PartyListResDto> parties = getPartyList(queryResult);
            Page<PartyListResDto> pagedParty = new PageImpl<>(parties,pageable,totalParties);
            return pagedParty;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<PartyListResDto> getPartyList(List<Object[]> queryResult) {
        List<PartyListResDto> parties = new ArrayList<>();
        for (Object[] row : queryResult) {
            PartyListResDto dto = new PartyListResDto();
            dto.setPartyId(convertObjToLong(row[0]));
            dto.setPartyName(convertObjToString(row[1]));
            parties.add(dto);
        }
        return parties;
    }

}
