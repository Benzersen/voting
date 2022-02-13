package com.corpfield.votingRegistration.controller;


import com.corpfield.votingRegistration.dto.CreatePartyReqDto;
import com.corpfield.votingRegistration.dto.EditPartyReqDto;
import com.corpfield.votingRegistration.dto.PartyListResDto;
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
    public ResponseEntity<String> createParty(@RequestBody CreatePartyReqDto partyReqDto) {
        myPartyService.createParty(partyReqDto);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


    @PutMapping("/party")
    public ResponseEntity<String> editPartyDetail (@RequestBody EditPartyReqDto reqDto) {
        myPartyService.editPartyDetail(reqDto);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @GetMapping("/party/{paged}")
    public ResponseEntity<Page<PartyListResDto>> ListPartyDetails (
            @PageableDefault(size = 2) Pageable pageable
    ) {
        Page<PartyListResDto> resDto = myPartyService.ListPartyDetails(pageable);
        return new ResponseEntity<>(resDto,HttpStatus.OK);
    }


}
