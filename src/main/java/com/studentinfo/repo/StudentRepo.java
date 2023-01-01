package com.studentinfo.repo;

import com.studentinfo.converter.StudentVOConverter;
import com.studentinfo.entities.Student;
import com.studentinfo.entities.Subjects;
import com.studentinfo.models.StudentVO;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class StudentRepo {

    List<Subjects> subjectsList;

    List<StudentVO> studentVOList;

    List<Student> students;

    @Autowired
    StudentVOConverter studentVOConverter;

    Student student ;

    public StudentRepo(){
        studentVOList = new ArrayList<>();
        studentVOList.add(StudentVO.builder().
                studentId(10L).
                fullName("Bruce Wayne").
                city("Gotham").
                rollNo(10).
                standard("10th").
                build());
//        studentVOList.add(StudentVO.builder().
//                studentId(11L).
//                fullName("Clark").
//                city("Gotham").
//                rollNo(11).
//                standard("10th").
//                build());
//        studentVOList.add(StudentVO.builder().
//                studentId(12L).
//                fullName("John").
//                city("Gotham").
//                rollNo(12).
//                standard("10th").
//                build());

        studentVOList.add(StudentVO.builder().
                subjectId(1L).
                studentRollNo(10).
                subjectName("English").
                marks(98).
                totalMarks(100).
                build());
        studentVOList.add(StudentVO.builder().
                subjectId(2L).
                studentRollNo(10).
                subjectName("Mathematics").
                marks(98).
                totalMarks(100).
                build());
        studentVOList.add(StudentVO.builder().
                subjectId(3L).
                studentRollNo(10).
                subjectName("Science").
                marks(98).
                totalMarks(100).
                build());
    }

    public List<StudentVO> studentVOList(){
        return studentVOConverter.studentVOList(students);
    }



}
