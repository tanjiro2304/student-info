package com.studentinfo.converter;

import com.studentinfo.entities.Student;
import com.studentinfo.models.StudentVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentVOConverter {
    public StudentVO convertToStudentVO(Student student){
        return StudentVO.builder().
                studentId(student.getStudentId()).
                fullName(student.getFullName()).
                city(student.getCity()).
                rollNo(student.getRollNo()).
                standard(student.getStandard()).
                build();
    }

//    public List<StudentVO> completeList(List<Student> list){
//        List<StudentVO> allList = new ArrayList<>();
//        list.stream().forEach(student -> allList.add(convertToStudentVO(student)));
//        list.stream().forEach(student -> listOfSubjects(student).stream().forEach(sub->allList.add(sub)));
//
//        return allList;
//    }

//    public List<StudentVO> listOfSubjects(Student student){
//        return student.getSubjectsList().stream().map(subjects -> StudentVO.builder().
//                subjectId(subjects.getSubjectId()).
//                subjectName(subjects.getSubjectName()).
//                studentRollNo(student.getRollNo()).
//                marks(subjects.getMarks()).
//                totalMarks(subjects.getTotalMarks()).
//                build()).collect(Collectors.toList());
//    }

    public List<StudentVO> studentVOList(List<Student> students){
        return students.stream().
                map(student ->StudentVO.builder().
                        studentId(student.getStudentId()).
                        fullName(student.getFullName()).
                        city(student.getCity()).
                        rollNo(student.getRollNo()).
                        standard(student.getStandard()).
                        build()
                        ).collect(Collectors.toList());
    }
}
