package com.Student.Details.Model.IO;


import lombok.Data;

import java.math.BigInteger;

@Data
public class StudentRequest {

    private Integer id;
    private String name;
    public BigInteger number;
    public String subject;
}
