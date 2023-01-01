package com.studentinfo.entities;

import lombok.*;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Long studentId;

    private String fullName;

    private String city;

    private Integer rollNo;

    private String standard;

}
