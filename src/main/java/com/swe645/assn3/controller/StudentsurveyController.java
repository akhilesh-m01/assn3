package com.swe645.assn3.controller;

import com.swe645.assn3.entity.Studentsurvey;
import com.swe645.assn3.service.StudentsurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studentsurvey")
public class StudentsurveyController {

    private final StudentsurveyService studentsurveyService;

    public StudentsurveyController(StudentsurveyService studentsurveyService) {
        super();
        this.studentsurveyService = studentsurveyService;
    }


    @GetMapping("/getstudentsurveys")
    public List<Studentsurvey> getAllStudentSurveys() {
        return studentsurveyService.getAllStudentsurveys();
    }


    @PostMapping("/createstudentsurvey")
    public ResponseEntity<Studentsurvey> createStudentSurvey(@RequestBody Studentsurvey studentsurvey) {
        return new ResponseEntity<Studentsurvey>(studentsurveyService.saveStudentsurvey(studentsurvey), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudentSurvey(@PathVariable("id") Long id, @RequestBody Studentsurvey studentsurvey) {
        Studentsurvey newSurvey = studentsurveyService.updateStudentsurvey(studentsurvey, id);

        if (newSurvey != null) {
            studentsurveyService.saveStudentsurvey(newSurvey);
            return new ResponseEntity<String>("Survey <" + id + "> has been successfully updated!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Survey update - failed", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentSurvey(@PathVariable("id") Long id) {
        boolean deletedStudentsurvey = studentsurveyService.deleteStudentsurvey(id);

        if (deletedStudentsurvey) {
            return new ResponseEntity<String>("Survey <" + id + "> has been successfully deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Survey deletion - failed. "+id+" - not found.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studentsurvey> getStudentSurveyById(@PathVariable("id") Long id){
        return new ResponseEntity<Studentsurvey>(studentsurveyService.getStudentsurveyById(id), HttpStatus.OK);
    }

}
