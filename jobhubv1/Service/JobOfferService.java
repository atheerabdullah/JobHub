package com.example.jobhubv1.Service;


import com.example.jobhubv1.ApiException.ApiException;
import com.example.jobhubv1.Model.Company;
import com.example.jobhubv1.Model.JobHub;
import com.example.jobhubv1.Model.JobOffer;
import com.example.jobhubv1.Model.Seeker;
import com.example.jobhubv1.Repository.CompanyRepository;
import com.example.jobhubv1.Repository.JobHubRepository;
import com.example.jobhubv1.Repository.JobOfferRepository;
import com.example.jobhubv1.Repository.SeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobOfferService {

    private final JobOfferRepository jobOfferRepository;
    private final CompanyRepository companyRepository;
    private final JobHubRepository jobHubRepository;
    private final SeekerRepository seekerRepository;


    public List<JobOffer> getAllJobOffer(){
        return jobOfferRepository.findAll();
    }


    public JobOffer addJobOffer(JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }
    public JobOffer updateJobOffer(JobOffer jobOffer, Integer id) {
        JobOffer updatedJobOffer= jobOfferRepository.findJobOfferByOfferid(id);
        if (updatedJobOffer == null) {
            throw new ApiException("Enter the correct Id");
        }
        updatedJobOffer.setDescription(jobOffer.getDescription());
        updatedJobOffer.setLocation(jobOffer.getLocation());
        updatedJobOffer.setPositionname(jobOffer.getPositionname());
        updatedJobOffer.setRequirements(jobOffer.getRequirements());
        jobOfferRepository.save(updatedJobOffer);
        return updatedJobOffer;
    }

    public void deleteJobOffer(Integer id) {
        JobOffer jobOffer = jobOfferRepository.findJobOfferByOfferid(id);
        if (jobOffer == null) {
            throw new ApiException("job Offer not found");
        }
        jobOfferRepository.delete(jobOffer);
    }
    public void assignOffersTCompany(Integer companyid,Integer offerid){
        //check if they both exist
        Company company= companyRepository.findCompaniesByCompanyid(companyid);
        JobOffer jobOffer=jobOfferRepository.findJobOfferByOfferid(offerid);

        if(company==null||jobOffer==null){
            throw new ApiException("can't assign Offer, wrong id");
        }
        jobOffer.setCompany(company);
        jobOfferRepository.save(jobOffer);
    }


    public void assignJobOfferToAPI(Integer offerid,Integer johubid){
        //check if they both exist
        JobHub jobHub=jobHubRepository.findJobHubById(johubid);
        JobOffer jobOffer=jobOfferRepository.findJobOfferByOfferid(offerid);
        if(jobHub==null||jobOffer==null){
            throw new ApiException("can't assign Offer, wrong id");
        }
        jobOffer.setJobhub(jobHub);
        jobOfferRepository.save(jobOffer);
    }

    public void assignSeekerToJobOffer(Integer seekerid,Integer offerid){

        JobOffer jobOffer=jobOfferRepository.findJobOfferByOfferid(offerid);
        Seeker seeker=seekerRepository.findSeekerBySeekerid(seekerid);

        if(jobOffer==null||offerid==null){
            throw new ApiException("wrong id, can't assign");
        }

        jobOffer.getSeekers().add(seeker); //take given courses then set them in student
        seeker.getJobOffers().add(jobOffer);
        jobOfferRepository.save(jobOffer);
        seekerRepository.save(seeker);
    }



}
