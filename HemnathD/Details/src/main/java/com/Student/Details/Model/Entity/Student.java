package com.Student.Details.Model.Entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "studentdetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @Column(name = "Student_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Number")
    public BigInteger number;

    @Column(name = "Subject")
    public String subject;
}
