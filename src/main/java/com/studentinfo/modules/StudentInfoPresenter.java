package com.studentinfo.modules;

import com.studentinfo.converter.StudentVOConverter;
import com.studentinfo.entities.Student;
import com.studentinfo.models.StudentVO;
import com.studentinfo.mvputils.BasePresenter;
import com.studentinfo.repo.StudentRepo;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UIScope
@SpringComponent
public class StudentInfoPresenter extends BasePresenter<StudentInfoView> {
    @Autowired
    StudentRepo studentRepo;



    public List<StudentVO> studentList(){
        return studentRepo.getStudentVOList();
    }


}
