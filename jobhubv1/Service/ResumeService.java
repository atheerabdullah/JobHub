package com.example.jobhubv1.Service;


import com.example.jobhubv1.ApiException.ApiException;
import com.example.jobhubv1.DTO.ResumeDTO;
import com.example.jobhubv1.Model.Resume;
import com.example.jobhubv1.Model.Seeker;
import com.example.jobhubv1.Repository.JobHubRepository;
import com.example.jobhubv1.Repository.ResumeRepository;
import com.example.jobhubv1.Repository.SeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final SeekerRepository seekerRepository;
    private final JobHubRepository jobHubRepository;


    public List<Resume> getAllResume(){
        return resumeRepository.findAll();
    }

    public void addResume(ResumeDTO resumeDTO){
        Seeker seeker = seekerRepository.findSeekerBySeekerid(resumeDTO.getSeekerid());
        if (seeker == null) {
            throw new ApiException("sorry can't add Resume, Seeker not found");
        }
        Resume resume = new Resume(null, resumeDTO.getResumeName(), resumeDTO.getEmail(),
                resumeDTO.getEducation(),resumeDTO.getExperience(),resumeDTO.getSkill(),seeker);
        resumeRepository.save(resume);
    }


    public void updateResume(ResumeDTO resumeDTO){
        Seeker seeker= seekerRepository.findSeekerBySeekerid(resumeDTO.getSeekerid());
        if(seeker==null){
            throw new ApiException("sorry can't update Resume, Seeker not found");
        }
        Resume resume=resumeRepository.findResumeByResumeid(resumeDTO.getSeekerid());
        resume.setEducation(resumeDTO.getEducation());
        resume.setResumeName(resumeDTO.getResumeName());
        resume.setSkill(resumeDTO.getSkill());
        resume.setExperience(resumeDTO.getExperience());
        resume.setEmail(resumeDTO.getEmail());
        resumeRepository.save(resume);
    }


    public void deleteResume(Integer id){
        Resume resume  = resumeRepository.findResumeByResumeid(id);
        if (resume == null)
        {
            throw new ApiException("Enter Correct id");
        }
        resumeRepository.delete(resume);
    }


}
