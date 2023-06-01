package com.example.jobhubv1.Repository;

import com.example.jobhubv1.Model.JobHub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHubRepository extends JpaRepository<JobHub , Integer> {

    JobHub findJobHubById(Integer id);

}
