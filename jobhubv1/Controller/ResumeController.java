package com.example.jobhubv1.Controller;


import com.example.jobhubv1.DTO.ResumeDTO;
import com.example.jobhubv1.Model.Resume;
import com.example.jobhubv1.Service.ResumeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Resume")
@RequiredArgsConstructor

public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping("/getResumes")
    public ResponseEntity getAllResume() {
        List<Resume> resume = resumeService.getAllResume();
        return ResponseEntity.status(200).body(resume);
    }


    @PostMapping("/addResume")
    public ResponseEntity addResume(@Valid @RequestBody ResumeDTO resumeDTO) {
        resumeService.addResume(resumeDTO);
        return ResponseEntity.status(200).body("Resume added successfully");
    }

    @PutMapping("/updateResume")
    public ResponseEntity updateResume(@Valid @RequestBody ResumeDTO resumeDTO) {
        resumeService.updateResume(resumeDTO);
        return ResponseEntity.status(200).body("Resume Updated successfully");
    }

    @DeleteMapping("/deleteResume/{id}")
    public ResponseEntity deleteResume(@PathVariable Integer id) {
        resumeService.deleteResume(id);
        return ResponseEntity.status(200).body("Resume deleted successfully");
    }



}
