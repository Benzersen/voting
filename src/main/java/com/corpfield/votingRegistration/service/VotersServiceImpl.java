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

import static com.corpfield.votingRegistration.utils.Queryutils.convertObjtoLong;
import static com.corpfield.votingRegistration.utils.Queryutils.convertObjtoString;

@Service
public class VotersServiceImpl implements VotersService {
    @Autowired
    VotersRepo votersrepo;

    @Autowired
    VotersDao votersdao;

    @Override
    public void createvoter(VotersCreateReqDto reqDto) {
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
    public void editvoter(VotersEditReqDto reqDto) {
        try{
            Optional<Voters> optionalvoter=votersrepo.findById(reqDto.getVoterId());
            if(optionalvoter.isPresent()){
                Voters voter=optionalvoter.get();
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
    public Page<VotersListResDto> listvotersbypage(Pageable pageable) {
        try {
            List<Object[]> queryResult = votersdao.getvoterswithpage(pageable);
            int totalvoters=votersdao.getTotalvoters();
            List<VotersListResDto> voters = getVotersList(queryResult);
            Page<VotersListResDto> Pagedvoters=new PageImpl<>(voters,pageable,totalvoters);
            return Pagedvoters;
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
            dto.setVoterId(convertObjtoLong(row[0]));
            dto.setFullName(convertObjtoString(row[1]));
            dto.setAddress(convertObjtoString(row[2]));
            dto.setPartyId(convertObjtoLong(row[3]));
            dto.setPartyName(convertObjtoString(row[4]));
            obj.add(dto);
        }
        return obj;
    }
}