package com.example.jobhubv1.Repository;

import com.example.jobhubv1.Model.Seeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeekerRepository extends JpaRepository <Seeker , Integer> {
    Seeker findSeekerBySeekerid(Integer id);
}
