package com.example.jobhubv1.Model;


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
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyid;

    @NotEmpty(message = "The name must not be empty")
    @Column(columnDefinition = "varchar(25) not null")
    @Size(min = 5, max = 25, message = "the company name should be between 5 and 25 characters")
    private String companyname;

    @Email(message = "Invalid email address")
    @NotEmpty(message = "The email must not be empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    //Relations

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private Set<JobOffer> jobOffers;


}
