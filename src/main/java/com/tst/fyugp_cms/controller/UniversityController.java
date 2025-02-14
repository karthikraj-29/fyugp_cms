package com.tst.fyugp_cms.controller;

import com.tst.fyugp_cms.dto.UniversityDto;
import com.tst.fyugp_cms.service.UniversityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/university")
public class UniversityController {

    private final UniversityService universityService;
    public UniversityController(UniversityService universityService){
        this.universityService = universityService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUniversity(@RequestBody UniversityDto universityDto){
        return ResponseEntity.ok(universityService.addUniversity(universityDto));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllUniversities(){
        return ResponseEntity.ok().body(universityService.getAllUniversities());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUniversityById(@PathVariable Long id){
        try{
            return ResponseEntity.ok().body(universityService.getUniversityById(id));

        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("University not found with id: " + id);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUniversity(@RequestBody UniversityDto universityDto,
                                              @PathVariable Long id){
        try {
            return ResponseEntity.ok().body(universityService.updateUniversity(universityDto, id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("University not found with id: " + id);
        }
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        if (universityService.deleteUniversity(id)) {
            return "Delete the university with id "+ id +" successfully";
        }
        return "Delete the university with id " + id +" failed";
    }
}
