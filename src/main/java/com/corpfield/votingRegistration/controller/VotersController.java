package com.corpfield.votingRegistration.controller;

import com.corpfield.votingRegistration.dto.ResponseDto;
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
    public ResponseEntity<ResponseDto> createVoter(@RequestBody VotersCreateReqDto  reqDto) {
        ResponseDto response=votersservice.createVoter(reqDto);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));

    }

    @PutMapping("/voters")
    public ResponseEntity<ResponseDto> editVoter(@RequestBody VotersEditReqDto reqDto) {
        ResponseDto response=votersservice.editVoter(reqDto);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/voters")
    public ResponseEntity<ResponseDto> getVotersByPaged(@PageableDefault(size = 2) Pageable myPageable){
         ResponseDto response=votersservice.listVotersByPage(myPageable);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/voters:PartyId")
    public ResponseEntity<ResponseDto> getVotersByPaged(@PageableDefault(size = 2) Pageable myPageable,@RequestParam("partyId") long partyId){
        ResponseDto response =votersservice.listVotersByPage(myPageable,partyId);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatus()));
    }

}
