package com.swe645.assn3.service;

import com.swe645.assn3.entity.Studentsurvey;
import com.swe645.assn3.repository.StudentsurveyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsurveyServiceImpl implements StudentsurveyService {


    public StudentsurveyRepository studentsurveyRepository;

    public StudentsurveyServiceImpl(StudentsurveyRepository studentsurveyRepository) {
        super();
        this.studentsurveyRepository = studentsurveyRepository;
    }


    @Override
    public Studentsurvey saveStudentsurvey(Studentsurvey studentsurvey) {
        return studentsurveyRepository.save(studentsurvey);
    }

    @Override
    public List<Studentsurvey> getAllStudentsurveys() {
        return studentsurveyRepository.findAll();
    }

    @Override
    public Studentsurvey getStudentsurveyById(long id) {
        Optional<Studentsurvey> studentsurvey = studentsurveyRepository.findById(id);

        if (studentsurvey.isPresent()) {
            return studentsurvey.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Studentsurvey updateStudentsurvey(Studentsurvey studentsurvey, long id) {
        Optional<Studentsurvey> mystudentsurveyid = studentsurveyRepository.findById(id);

        if (mystudentsurveyid.isPresent()) {
            Studentsurvey presentSurvey = mystudentsurveyid.get();
            presentSurvey.setStudentFirstName(studentsurvey.getStudentFirstName());
            presentSurvey.setStudentLastName(studentsurvey.getStudentLastName());
            presentSurvey.setStudentStreetAddress(studentsurvey.getStudentStreetAddress());
            presentSurvey.setStudentCity(studentsurvey.getStudentCity());
            presentSurvey.setStudentState(studentsurvey.getStudentState());
            presentSurvey.setStudentZip(studentsurvey.getStudentZip());
            presentSurvey.setStudentPhoneNumber(studentsurvey.getStudentPhoneNumber());
            presentSurvey.setStudentEmail(studentsurvey.getStudentEmail());
            presentSurvey.setStudentDateOfSurvey(studentsurvey.getStudentDateOfSurvey());
            presentSurvey.setStudentLikedMost(studentsurvey.getStudentLikedMost());
            presentSurvey.setStudentInterestedIn(studentsurvey.getStudentInterestedIn());
            presentSurvey.setStudentLikelihood(studentsurvey.getStudentLikelihood());
            return presentSurvey;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteStudentsurvey(long id) {
        Optional<Studentsurvey> mystudentsuveyid = studentsurveyRepository.findById(id);

        if (mystudentsuveyid.isPresent()) {
            studentsurveyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
