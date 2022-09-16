package com.bridgelabz.Exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@NoArgsConstructor
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserBookRegistrationException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    HttpStatus status;
    String statusMsg;
    private String message;
    private Object data;

    public UserBookRegistrationException(String message,HttpStatus status, Object data, String statusMsg)
    {
        super();
        this.message = message;
        this.status = status;
        this.data = data;
        this.statusMsg = statusMsg;
    }
}
