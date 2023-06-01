package com.example.jobhubv1.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
public class JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer offerid;

    @NotEmpty(message = "The position Name must not be empty")
    @Column(columnDefinition = "varchar(25) not null")
    @Size(min = 1, max = 25, message = "the position name should be at least 25 characters")
    private String positionname;

    @NotEmpty(message = "The description must not be empty")
    @Column(columnDefinition = "varchar(45) not null")
    @Size(min = 1, max = 45, message = "the description should be t least 45 characters")
    private String description;

    @NotEmpty(message = "The requirements must not be empty")
    @Column(columnDefinition = "varchar(255) not null")
    @Size(min = 1, max = 225, message = "the position name should be at least 25 characters")
    private String requirements;

    @NotEmpty(message = "Location must be on { Jeddah - Riyadh - Dammam }")
    @Column(columnDefinition = "VARCHAR(255) check (location='jeddah' or location='Riyadh' or location='Dammam')")
    private String location;




    //Relations:

    @ManyToOne
    @JoinColumn(name = "companyid",referencedColumnName = "companyid")
    @JsonIgnore
    private Company company;

    @ManyToOne
    @JoinColumn(name = "johubid",referencedColumnName = "id")
    @JsonIgnore
    private JobHub jobhub;

    @ManyToMany
    @JsonIgnore
    private Set<Seeker> seekers;

}
