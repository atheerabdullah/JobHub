package com.example.jobhubv1.Service;


import com.example.jobhubv1.ApiException.ApiException;
import com.example.jobhubv1.Model.JobHub;
import com.example.jobhubv1.Model.Resume;
import com.example.jobhubv1.Model.Seeker;
import com.example.jobhubv1.Repository.JobHubRepository;
import com.example.jobhubv1.Repository.SeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeekerService {


    private final SeekerRepository seekerRepository;
    private final JobHubRepository jobHubRepository;



    public List<Seeker> getAllSeeker(){
        return seekerRepository.findAll();
    }

    public Seeker addSeeker(Seeker seeker) {
        return seekerRepository.save(seeker);
    }

    public Seeker updateSeeker(Seeker seeker , Integer id) {
        Seeker updatedSeeker =seekerRepository.findSeekerBySeekerid(id);
        if (updatedSeeker == null) {
            throw new ApiException("Enter Correct id");
        }
        updatedSeeker.setSeekername(seeker.getSeekername());
        seekerRepository.save(updatedSeeker);
        return updatedSeeker;
    }

    public void deleteSeeker(Integer id){
        Seeker seeker  = seekerRepository.findSeekerBySeekerid(id);
        if (seeker == null)
        {
            throw new ApiException("Enter Correct id");
        }
        seekerRepository.delete(seeker);
    }

    //assign job offers to API
    public void assignSeekerToAPI(Integer seekerid , Integer johubid){
        JobHub jobHub=jobHubRepository.findJobHubById(johubid);
        Seeker seeker=seekerRepository.findSeekerBySeekerid(seekerid);

        if(jobHub==null||seeker==null){
            throw new ApiException("can't assign Offer, wrong id");
        }
        seeker.setJobhub(jobHub);
        seekerRepository.save(seeker);
    }

//    public Resume CheckForApply(String skill, Integer resumeid){
//        Resume resume1=resumeRepository.findResumeByResumeid(resumeid);
//        Resume x=resume1.getSkill(skill);
//        if(x.equals("programming")){
//            throw new ApiResponse("congrats");
//        }
//        throw new ApiException("sorry, ur skill doesnt match") ;
//    }


}
