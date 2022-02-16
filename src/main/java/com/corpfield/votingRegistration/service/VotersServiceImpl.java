package com.corpfield.votingRegistration.service;

import com.corpfield.votingRegistration.dao.VotersDao;
import com.corpfield.votingRegistration.dto.VotersCreateReqDto;
import com.corpfield.votingRegistration.dto.VotersEditReqDto;
import com.corpfield.votingRegistration.dto.VotersListResDto;
import com.corpfield.votingRegistration.entity.Voters;
import com.corpfield.votingRegistration.repo.VotersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.corpfield.votingRegistration.utils.QueryUtils.*;

@Service
public class VotersServiceImpl implements VotersService {
    @Autowired
    VotersRepo votersrepo;

    @Autowired
    VotersDao votersdao;

    @Override
    public void createVoter(VotersCreateReqDto reqDto) {
        try{
            Voters voter=new Voters();
            voter.setFullName(reqDto.getFullName());
            voter.setAddress(reqDto.getAddress());
            votersrepo.save(voter);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void editVoter(VotersEditReqDto reqDto ) {
        try{
            Optional<Voters> optionalVoter=votersrepo.findById(reqDto.getVoterId());
            if(optionalVoter.isPresent()){
                Voters voter=optionalVoter.get();
                voter.setFullName(reqDto.getFullName());
                voter.setAddress(reqDto.getAddress());
                votersrepo.save(voter);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Page<VotersListResDto> listVotersByPage(Pageable pageable) {
        try {
            List<Object[]> queryResult = votersdao.getvoterswithpage(pageable);
            int totalVoters=votersdao.getTotalvoters();
            List<VotersListResDto> voters = getVotersList(queryResult);
            Page<VotersListResDto> PagedVoters=new PageImpl<>(voters,pageable,totalVoters);
            return PagedVoters;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
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
