package com.swe645.assn3.service;

import com.swe645.assn3.entity.Studentsurvey;

import java.util.List;

public interface StudentsurveyService {

    Studentsurvey saveStudentsurvey(Studentsurvey student);
    List<Studentsurvey> getAllStudentsurveys();
    Studentsurvey getStudentsurveyById(long id);
    Studentsurvey updateStudentsurvey(Studentsurvey student, long id);
    boolean deleteStudentsurvey(long id);

}

