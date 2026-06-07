package kr.adadpterz.springboot_project.exception;

import org.springframework.http.HttpStatus;

public class PasswordMismatchException extends BusinessException{
    public PasswordMismatchException(String code){
        super(code, HttpStatus.BAD_REQUEST);
    }
}
