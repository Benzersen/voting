package com.corpfield.votingRegistration.dto.responseDto;


import lombok.Data;

import java.util.Date;

@Data
public class ResponseDto {

    private Date time;
    private int status;
    private int code;
    private Object data;

    public ResponseDto(Object object, int code) {
        this.code = code;
        this.status = code;
        this.time = new Date();
        this.data = object;
    }

}
