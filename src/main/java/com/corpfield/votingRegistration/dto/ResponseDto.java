package com.corpfield.votingRegistration.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ResponseDto {
    private Date time;
    private int status;
    private int code;
    private Object data;

public ResponseDto(Object object,int code){
    this.time=new Date();
    this.status=code;
    this.code=code;
    this.data=object;
}

}
