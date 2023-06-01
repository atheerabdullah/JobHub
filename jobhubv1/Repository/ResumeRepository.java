package com.example.jobhubv1.Repository;

import com.example.jobhubv1.Model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume , Integer> {
    Resume findResumeByResumeid(Integer id);
    List<Resume> findResumeBySkill(String skill);
    List<Resume>findResumeByExperience(String experience);
    List<Resume>findResumeByEducation(String education);

    // resume id to get skill to checking

}
