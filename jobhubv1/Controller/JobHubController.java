package com.example.jobhubv1.Controller;


import com.example.jobhubv1.Model.JobHub;
import com.example.jobhubv1.Model.JobOffer;
import com.example.jobhubv1.Model.Resume;
import com.example.jobhubv1.Model.Seeker;
import com.example.jobhubv1.Service.JobHubService;
import com.example.jobhubv1.Service.SeekerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/JobHub")
@RequiredArgsConstructor
public class JobHubController {

    private final JobHubService jobHubService;

    private final SeekerService seekerService;

    @GetMapping("/get-joboffer")
    public ResponseEntity getAllJobOffers(){
        List<JobOffer> jobOffers=jobHubService.getAllJobOffers();
        return ResponseEntity.status(200).body(jobOffers);
    }

    //get all seekers with their resume

    @GetMapping("/get-allSeekers")
    public ResponseEntity getAllSeeker() {
        List<Seeker> seekers = seekerService.getAllSeeker();
        return ResponseEntity.status(200).body(seekers);
    }

    @GetMapping("/get-jobByLocation/{location}")
    public ResponseEntity getAlljobByLocation(@PathVariable String location){
        List<JobOffer> jobOffers=jobHubService.getAllJobByLocation(location);
        return ResponseEntity.status(200).body(jobOffers);
    }

    @GetMapping("/get-OfferByPositionName/{positionname}")
    public ResponseEntity getOfferByPositionName(@PathVariable String positionname){
        JobOffer jobOffers=jobHubService.getOfferByPName(positionname);
        return ResponseEntity.status(200).body(jobOffers);
    }

    @GetMapping("/get-OfferByCompanyName/{companyname}")
    public ResponseEntity getOfferCompanyName(@PathVariable String companyname){
        List<JobOffer> jobOffers=jobHubService.getJobOfferByCompanyName(companyname);
        return ResponseEntity.status(200).body(jobOffers);
    }

    @GetMapping("/get-ResumeBySkill/{skill}")
    public ResponseEntity getResumeBySkill(@PathVariable String skill){
        List<Resume> resumes=jobHubService.getResumeBySkill(skill);
        return ResponseEntity.status(200).body(resumes);
    }

    @GetMapping("/get-ResumeByExperience/{experience}")
    public ResponseEntity getResumeByExperience(@PathVariable String experience){
        List<Resume> resumes=jobHubService.getResumeBySkill(experience);
        return ResponseEntity.status(200).body(resumes);
    }

    @GetMapping("/get-ResumeByEducation/{education}")
    public ResponseEntity getResumeByEducation(@PathVariable String education){
        List<Resume> resumes=jobHubService.findResumeByEducation(education);
        return ResponseEntity.status(200).body(resumes);
    }
}



