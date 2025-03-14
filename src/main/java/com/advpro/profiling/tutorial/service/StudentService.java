package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentsWithCourses() {
        // Retrieve all students in a single call and map them by their ID
        List<Student> students = studentRepository.findAll();
        Map<Long, Student> studentMap = new HashMap<>();
        for (Student student : students) {
            studentMap.put(student.getId(), student);
        }

        // Retrieve all student-course associations in one call
        List<StudentCourse> allStudentCourses = studentCourseRepository.findAll();
        List<StudentCourse> result = new ArrayList<>(allStudentCourses.size());

        // For each association, get the fully populated student from the map and construct a new association
        for (StudentCourse sc : allStudentCourses) {
            Long studentId = sc.getStudent().getId();
            Student student = studentMap.get(studentId);
            if (student != null) {
                StudentCourse newSC = new StudentCourse();
                newSC.setStudent(student);
                newSC.setCourse(sc.getCourse());
                result.add(newSC);
            }
        }
        return result;
    }


    public Optional<Student> findStudentWithHighestGpa() {
        return studentRepository.findAll().stream()
                .max(Comparator.comparingDouble(Student::getGpa));
    }


    public String joinStudentNames() {
        return studentRepository.findAll().stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
    }

}

