package com.corpfield.votingRegistration.service;

import com.corpfield.votingRegistration.constants.ResponseCodes;
import com.corpfield.votingRegistration.dao.VotersDao;
import com.corpfield.votingRegistration.dto.ResponseDto;
import com.corpfield.votingRegistration.dto.VotersCreateReqDto;
import com.corpfield.votingRegistration.dto.VotersEditReqDto;
import com.corpfield.votingRegistration.dto.VotersListResDto;
import com.corpfield.votingRegistration.entity.Parties;
import com.corpfield.votingRegistration.entity.Voters;
import com.corpfield.votingRegistration.exceptions.ServiceException;
import com.corpfield.votingRegistration.repo.PartiesRepo;
import com.corpfield.votingRegistration.repo.VotersRepo;
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
public class VotersServiceImpl implements VotersService {
    @Autowired
    VotersRepo votersrepo;

    @Autowired
    PartiesRepo partyRepo;

    @Autowired
    VotersDao votersdao;

    @Override
    public ResponseDto createVoter(VotersCreateReqDto reqDto) {
        try {
            Voters voter = new Voters();
            voter.setFullName(reqDto.getFullName());
            voter.setAddress(reqDto.getAddress());
            Optional<Parties> partyoptional = partyRepo.findById(reqDto.getPartyId());
            if (partyoptional.isPresent()) {
                Parties party = partyoptional.get();
                voter.setParties(party);
            }
            votersrepo.save(voter);
            String response = "you have voted successfully";
            return new ResponseDto(response, ResponseCodes.SUCCESS);
        } catch (Exception e) {
            return ServiceException.sendErrorResponse(e);
        }

    }

    @Override
    public ResponseDto editVoter(VotersEditReqDto reqDto) {
        try {
            Optional<Voters> optionalvoter = votersrepo.findById(reqDto.getVoterId());
            if (optionalvoter.isPresent()) {
                Voters voter = optionalvoter.get();
                voter.setFullName(reqDto.getFullName());
                voter.setAddress(reqDto.getAddress());
                Optional<Parties> partyoptional = partyRepo.findById(reqDto.getPartyId());
                if (partyoptional.isPresent()) {
                    Parties party = partyoptional.get();
                    voter.setParties(party);
                }
                votersrepo.save(voter);
            }
                String response = "you have voted successfully";
                return new ResponseDto(response, ResponseCodes.SUCCESS);

            }
         catch (Exception e) {
            return ServiceException.sendErrorResponse(e);
        }
    }


    @Override
    public ResponseDto listVotersByPage(Pageable pageable) {
        try {
            List<Object[]> queryResult = votersdao.getvoterswithpage(pageable);
            int totalvoters=votersdao.getTotalvoters();
            List<VotersListResDto> voters = getVotersList(queryResult);
            Page<VotersListResDto> Pagedvoters=new PageImpl<>(voters,pageable,totalvoters);
            return new ResponseDto(Pagedvoters, ResponseCodes.SUCCESS);
        }
        catch (Exception e) {
            return ServiceException.sendErrorResponse(e);
        }

    }

    @Override
    public ResponseDto listVotersByPage(Pageable pageable, long partyId) {
        try {
            if(partyId < 1){
                throw new ServiceException("Please enter a valid partyId");
            }
            List<Object[]> queryResult = votersdao.getvoterswithpage(pageable);
            int totalvoters=votersdao.getTotalvoters();
            List<VotersListResDto> voters = getVotersList(queryResult);
            Page<VotersListResDto> Pagedvoters=new PageImpl<>(voters,pageable,totalvoters);
            return new ResponseDto(Pagedvoters, ResponseCodes.SUCCESS);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto(null, ResponseCodes.SERVER_ERROR);
        }

    }


    private List<VotersListResDto> getVotersList(List<Object[]> queryResult){
        List<VotersListResDto> obj = new ArrayList<>();
        for(Object[] row:queryResult){
            VotersListResDto dto=new VotersListResDto();
            dto.setVoterId(convertObjToLong(row[0]));
            dto.setFullName(convertObjToString(row[1]));
            dto.setAddress(convertObjToString(row[2]));
            dto.setPartyId(convertObjToLong(row[3]));
            dto.setPartyName(convertObjToString(row[4]));
            obj.add(dto);
        }
        return obj;
    }
}
