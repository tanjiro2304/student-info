package com.studentinfo.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StudentVO {
    private Long studentId;

    private String fullName;

    private String city;

    private Integer rollNo;

    private String standard;

    private Integer studentRollNo;

    private Long subjectId;
    private String subjectName;
    private Integer marks;
    private Integer totalMarks;
}
