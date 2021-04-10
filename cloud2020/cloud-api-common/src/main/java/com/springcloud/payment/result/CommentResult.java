package com.springcloud.payment.result;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentResult<T> {
    private String code;
    private String message;
    private T data;

    public CommentResult(String code, String message){
        this.code=code;
        this.message=message;
        this.data=null;
    }

    public CommentResult(String code, String message,T data){
        this.code=code;
        this.message=message;
        this.data=data;
    }
}
