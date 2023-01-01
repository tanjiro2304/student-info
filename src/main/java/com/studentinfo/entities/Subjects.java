package com.studentinfo.entities;

import lombok.*;

import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subjects {
    private Long subjectId;
    private String subjectName;
    private Integer marks;

    private Integer totalMarks;



}
