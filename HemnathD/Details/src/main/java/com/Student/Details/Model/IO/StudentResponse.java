package com.Student.Details.Model.IO;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class StudentResponse {

    public Integer id;
    public String name;
    public BigInteger number;
    public String subject;
}
