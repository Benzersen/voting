package com.corpfield.votingRegistration.exceptions;


import com.corpfield.votingRegistration.constants.ResponseCodes;
import com.corpfield.votingRegistration.dto.responseDto.ResponseDto;

public class ServiceException extends RuntimeException {
    private String errorMessage;

    public ServiceException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public static ResponseDto sendErrorResponse(Exception e) {
        if (e instanceof ServiceException) {
            return new ResponseDto(e.getMessage(), ResponseCodes.INVALID_INPUT);
        }
        System.out.println("Internal Server Error");
        e.printStackTrace();
        return new ResponseDto(null,ResponseCodes.SERVER_ERROR);
    }

}
