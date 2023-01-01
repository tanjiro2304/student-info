package com.studentinfo.modules;

import com.studentinfo.converter.StudentVOConverter;
import com.studentinfo.entities.Student;
import com.studentinfo.models.StudentVO;
import com.studentinfo.mvputils.BaseView;
import com.studentinfo.repo.StudentRepo;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@UIScope
@SpringComponent
@Route("")
public class StudentInfoView extends BaseView<StudentInfoPresenter> {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    StudentVOConverter studentVOConverter;

    List<StudentVO> studentVOList;

    VerticalLayout verticalLayout;
    private TreeGrid<StudentVO> treeGrid;

    @Override
    protected void init() {
        studentVOList = getPresenter().studentList();

        setTreeGrid();
        add(treeGrid);

    }

    public void setTreeGrid(){
        treeGrid = new TreeGrid<>();
        treeGrid.setItems(studentVOS(),this::subjectList);
        treeGrid.addHierarchyColumn(StudentVO::getFullName).setHeader("Full Name");
        treeGrid.addColumn(StudentVO::getMarks).setHeader("Marks");
        treeGrid.addColumn(StudentVO::getSubjectName).setHeader("Subject");
    }

    public List<StudentVO> subjectList(StudentVO student){
        List<StudentVO> subs = studentVOS().stream().filter(sub-> sub.getStudentId() == null).
                collect(Collectors.toList());

        return subs.stream().
                filter(sub -> student.getRollNo().equals(sub.getStudentRollNo())).
                collect(Collectors.toList());
    }

    public List<StudentVO> studentVOS(){
        return  studentRepo.getStudentVOList().stream().filter(studentVO -> studentVO.getSubjectId() == null).
                collect(Collectors.toList());
    }


}
