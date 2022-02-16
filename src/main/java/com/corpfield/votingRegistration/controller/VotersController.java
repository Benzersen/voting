package com.corpfield.votingRegistration.controller;

import com.corpfield.votingRegistration.dto.VotersCreateReqDto;
import com.corpfield.votingRegistration.dto.VotersEditReqDto;
import com.corpfield.votingRegistration.dto.VotersListResDto;
import com.corpfield.votingRegistration.service.VotersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VotersController {
    @Autowired
    VotersService votersservice;

    @PostMapping("/voters")
    public ResponseEntity<String> createVoter(@RequestBody VotersCreateReqDto  reqDto) {
        votersservice.createVoter(reqDto);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PutMapping("/voters")
    public ResponseEntity<String> editVoter(@RequestBody VotersEditReqDto reqDto) {
        votersservice.editVoter(reqDto);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/voters")
    public ResponseEntity<Page<VotersListResDto>> getVotersByPaged(@PageableDefault(size = 2) Pageable myPageable){
        Page<VotersListResDto> voters=votersservice.listVotersByPage(myPageable);
        return new ResponseEntity<>(voters,HttpStatus.OK);
    }

}
