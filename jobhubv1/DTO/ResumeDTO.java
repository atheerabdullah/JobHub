package com.example.jobhubv1.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResumeDTO {


    private Integer seekerid;

    private String resumeName;
    private String email;
    private String education;
    private String experience;
    private String skill;

}
