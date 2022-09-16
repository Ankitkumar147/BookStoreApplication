package com.bridgelabz.DTO;

import lombok.Data;

@Data
public class ResponseDto {
        private String message;
        private Object data;

        public ResponseDto(String message,Object data){
            super();
            this.message = message;
            this.data = data;
        }
}
