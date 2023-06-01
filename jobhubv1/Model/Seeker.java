package com.example.jobhubv1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Seeker {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seekerid;


    @NotEmpty(message = "The seeker Name must not be empty")
    @Column(columnDefinition = "varchar(300) not null")
    @Size(min = 1, max = 300, message = "the seeker name should be between 5 and 25 characters")
    private String seekername;



    //Relations

    //seeker-resume
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "seeker")
    @PrimaryKeyJoinColumn
    private Resume resume;


    //seeker - JobHub
    @ManyToOne
    @JoinColumn(name = "johubid",referencedColumnName = "id")
    @JsonIgnore
    private JobHub jobhub;

//seeker - JobOffer
    @ManyToMany(mappedBy = "seekers")
    private Set<JobOffer> jobOffers;

}
