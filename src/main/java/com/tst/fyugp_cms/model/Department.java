package com.tst.fyugp_cms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    private String departmentName;
    private String departmentCode;
    @ManyToMany
    @JoinTable(
            name = "student_department",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "college_id")
    )
    private List<College>  college;

    @ManyToMany
    @JoinTable(
            name = "programme_department",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "programme_id")
    )
    private List<Programme> programmes;

    @OneToMany(mappedBy = "department")
    private List<StudentProfile> studentProfiles;

}
