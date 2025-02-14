package com.tst.fyugp_cms.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class College {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String collegeName;

    @Column(nullable = false, unique = true)
    private String collegeCode;

    private String collegeDescription;
    private String collegeLocation;
    private String collegeEmail;
    private String collegePhone;
    private String collegeWebsite;

    @ManyToOne
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @ManyToMany
    @JoinTable(
            name = "college_department",
            joinColumns = @JoinColumn(name = "college_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<Department> departments;
    @OneToMany(mappedBy = "college")
    private List<StudentProfile> studentProfiles;

}
