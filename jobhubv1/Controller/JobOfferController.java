package com.example.jobhubv1.Controller;


import com.example.jobhubv1.Model.JobOffer;
import com.example.jobhubv1.Service.JobOfferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/JobOffer")
@RequiredArgsConstructor
public class JobOfferController {

    private final JobOfferService jobOfferService;

    @GetMapping("/getJobOffers")

    public ResponseEntity getAllJobOffers(){
        List<JobOffer> jobOfferList=jobOfferService.getAllJobOffer();
        return ResponseEntity.status(200).body(jobOfferList);
    }


    @PostMapping("/addJobOffer")
    public ResponseEntity addJobOffer(@Valid @RequestBody JobOffer jobOffer ){
        jobOfferService.addJobOffer(jobOffer);
        return ResponseEntity.status(200).body("Job Offer added");
    }


    @PutMapping("/updateJobOffer/{id}")
    public ResponseEntity updateJobOffer(@Valid @RequestBody JobOffer jobOffer, @PathVariable Integer id){
        jobOfferService.updateJobOffer(jobOffer,id);
        return ResponseEntity.status(200).body("job Offer Updated");
    }


    @DeleteMapping("/deleteJobOffer/{id}")
    public ResponseEntity deleteJobOffer(@PathVariable Integer id){
        jobOfferService.deleteJobOffer(id);
        return ResponseEntity.status(200).body("Job Offer deleted");
    }

    @PutMapping("/assignCompany/{offerid}/{companyid}")
    public ResponseEntity assignOfferToCompany(@PathVariable Integer companyid, @PathVariable Integer offerid){
        jobOfferService.assignOffersTCompany(companyid, offerid);
        return ResponseEntity.status(200).body("assign offer to company done");
    }

    //assigning method controller
    @PutMapping("/assignAPI/{offerid}/{johubid}")
    public ResponseEntity assignOfferToAPI(@PathVariable Integer johubid, @PathVariable Integer offerid){
        jobOfferService.assignJobOfferToAPI(johubid, offerid);
        return ResponseEntity.status(200).body("assign offer to JobHub done");
    }


    @PutMapping("/assignSeeker/{seekerid}/{offerid}")
    public ResponseEntity assignSeekerToJobOffer(@PathVariable Integer seekerid,@PathVariable Integer offerid){
        jobOfferService.assignSeekerToJobOffer(seekerid,offerid);
        return ResponseEntity.status(200).body("assign seeker to JobOffer donee");
    }


}
