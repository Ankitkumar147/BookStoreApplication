package com.bridgelabz.Response;

import com.bridgelabz.Model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
public class Response {
    String message;
    int status;
    Object data;
    String statusMsg;
    public Response(String message,Object user, int status,String statusMsg)
    {
     this.message = message;
     this.status = status;
     this.data = user;
     this.statusMsg= statusMsg;
    }
    public Response(String string, List<User> isUserPresent, int i, boolean b, HttpStatus ok)
    {

    }
    public  Response(String string , Object object){

    }
    public void setPassword(String encode){

    }
}
