package com.example.jobhubv1.Controller;

import com.example.jobhubv1.Model.Seeker;
import com.example.jobhubv1.Service.SeekerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Seeker")
@RequiredArgsConstructor
public class SeekerController {

    private final SeekerService seekerService;

    @GetMapping("/getSeeker")
    public ResponseEntity getAllSeeker() {
        List<Seeker> seeker = seekerService.getAllSeeker();
        return ResponseEntity.status(200).body(seeker);
    }


    @PostMapping("/addSeeker")
    public ResponseEntity addSeeker(@Valid @RequestBody Seeker seeker) {
        seekerService.addSeeker(seeker);
        return ResponseEntity.status(200).body("seeker added successfully");
    }
    @PutMapping("/updateSeeker/{id}")
    public ResponseEntity updateSeeker(@Valid @RequestBody Seeker seeker, @PathVariable Integer id) {
        seekerService.updateSeeker(seeker, id);
        return ResponseEntity.status(200).body("seeker updated successfully");
    }

    @DeleteMapping("/deleteSeeker/{id}")
    public ResponseEntity deleteSeeker(@PathVariable Integer id) {
        seekerService.deleteSeeker(id);
        return ResponseEntity.status(200).body("seeker deleted successfully");
    }


    //assigning method controller
    @PutMapping("/assignSeekerToAPI/{seekerid}/{johubid}")
    public ResponseEntity assignSeekerToAPI(@PathVariable Integer johubid, @PathVariable Integer seekerid){
        seekerService.assignSeekerToAPI(johubid, seekerid);
        return ResponseEntity.status(200).body("assign seeker to JobHub done");
    }

//    @PostMapping("/apply/{resumeid}/{skill}")
//    public ResponseEntity Apply(@PathVariable Integer resumeid,@PathVariable String skill){
//        seekerService.CheckForApply(skill,resumeid);
//        return ResponseEntity.status(200).body("");
//    }

}
