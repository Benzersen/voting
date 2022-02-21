package com.corpfield.votingRegistration.controller;


import com.corpfield.votingRegistration.dto.CreatePartyReqDto;
import com.corpfield.votingRegistration.dto.EditPartyReqDto;
import com.corpfield.votingRegistration.dto.PartyListResDto;
import com.corpfield.votingRegistration.dto.ResponseDto;
import com.corpfield.votingRegistration.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartyController {

    @Autowired
    PartyService myPartyService;


    @PostMapping("/party")
    public ResponseEntity<ResponseDto> createParty(@RequestBody CreatePartyReqDto partyReqDto) {
        ResponseDto response = myPartyService.createParty(partyReqDto);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PutMapping("/party")
    public ResponseEntity<ResponseDto> editPartyDetail (@RequestBody EditPartyReqDto reqDto) {
        ResponseDto response = myPartyService.editPartyDetail(reqDto);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/party/{paged}")
    public ResponseEntity<ResponseDto> ListPartyDetails (
            @PageableDefault(size = 2) Pageable pageable
    ) {
        ResponseDto response = myPartyService.ListPartyDetails(pageable);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatus()));
    }

}
