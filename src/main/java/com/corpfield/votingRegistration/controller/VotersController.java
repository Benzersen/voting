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
    public ResponseEntity<String> createvoter(@RequestBody VotersCreateReqDto  reqDto) {
        votersservice.createvoter(reqDto);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PutMapping("/voters")
    public ResponseEntity<String> editvoter(@RequestBody VotersEditReqDto reqDto) {
        votersservice.editvoter(reqDto);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/voters")
    public ResponseEntity<Page<VotersListResDto>> getvotersbypaged(@PageableDefault(size = 2) Pageable myPageable){
        Page<VotersListResDto> voters=votersservice.listvotersbypage(myPageable);
        return new ResponseEntity<>(voters,HttpStatus.OK);
    }

    @GetMapping("/voters:PartyId")
    public ResponseEntity<Page<VotersListResDto>> getvotersbypaged(@PageableDefault(size = 2) Pageable myPageable,@RequestParam("partyId") long partyId){
        Page<VotersListResDto> voters=votersservice.listvotersbypage(myPageable,partyId);
        return new ResponseEntity<>(voters,HttpStatus.OK);
    }

}
