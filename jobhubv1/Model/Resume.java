package com.example.jobhubv1.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor

@Setter
@Getter
@Entity
public class Resume {

    @Id
    private Integer resumeid;


    @NotEmpty(message = " name resume  cannot be null")
    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String resumeName;


    @Email(message = "Invalid email address")
    @NotEmpty(message = "The email must not be empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;


    @NotEmpty(message = "Education cannot be null")
    @Column(nullable = false, length = 255, columnDefinition = "VARCHAR(255) check (education in ('diploma', 'Bachelors'))")
    private String education;

    @NotEmpty(message = "Experience cannot be null")
    @Column(nullable = false, length = 255, columnDefinition = "VARCHAR(255) check (experience in ('Fresh', 'Entry'))")
    private String experience;

    @Column(nullable = false, length = 255, columnDefinition = "VARCHAR(255) check (skill in ('programming', 'english'))")
    private String skill;


    //Relations


    //seeker-resume
    @OneToOne
    @MapsId
    @JsonIgnore
    private Seeker seeker;

}
