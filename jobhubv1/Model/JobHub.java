package com.example.jobhubv1.Model;


import jakarta.persistence.*;
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
public class JobHub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;




    //Relations
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "jobhub")
    private Set<JobOffer> jobOffers;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "jobhub")
    private Set<Seeker> seekers;
}
