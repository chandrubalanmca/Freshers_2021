package com.Student.Details.Model.IO;

import lombok.Data;

@Data
public class ResponseWrapper<T> {
    private  boolean success;
    private  T data;
    private Object error;

    public ResponseWrapper(boolean success, T data) {
        this.success =success;
        this.data = data;
    }
}
