package com.example.jobhubv1.Service;

import com.example.jobhubv1.Model.JobHub;
import com.example.jobhubv1.Model.JobOffer;
import com.example.jobhubv1.Model.Resume;
import com.example.jobhubv1.Repository.JobHubRepository;
import com.example.jobhubv1.Repository.JobOfferRepository;
import com.example.jobhubv1.Repository.ResumeRepository;
import com.example.jobhubv1.Repository.SeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobHubService {

    private final JobHubRepository jobHubRepository;
    private final JobOfferRepository jobOfferRepository;
    private final SeekerRepository seekerRepository;
    private final ResumeRepository resumeRepository;

    //all job offers
    public List<JobOffer> getAllJobOffers(){
        return jobOfferRepository.findAll();
    }



    //get by location
    public List<JobOffer> getAllJobByLocation(String location){
        return jobOfferRepository.findJobOfferByLocation(location);
    }

    //get offer by position name
    public JobOffer getOfferByPName(String positionname){
        return jobOfferRepository.findJobOfferByPositionname(positionname);
    }
    // get offer by company name
    public List<JobOffer>getJobOfferByCompanyName(String companyname){
        return jobOfferRepository.findJobOfferByCompanyCompanyname(companyname);
    }

    public List<Resume> getResumeBySkill(String skill){
        return resumeRepository.findResumeBySkill(skill);
    }

    public List<Resume> getResumeByExperience(String experience){
        return resumeRepository.findResumeByExperience(experience);
    }

    public List<Resume> findResumeByEducation(String education){
        return resumeRepository.findResumeByEducation(education);
    }





}
