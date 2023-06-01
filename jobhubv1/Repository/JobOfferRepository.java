package com.example.jobhubv1.Repository;

import com.example.jobhubv1.Model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobOfferRepository extends JpaRepository <JobOffer , Integer > {
    JobOffer findJobOfferByOfferid(Integer id);

    List<JobOffer> findJobOfferByLocation(String location);
    JobOffer findJobOfferByPositionname(String positionname);

    List<JobOffer>findJobOfferByCompanyCompanyname(String companyname);


}
