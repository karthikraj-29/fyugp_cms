package com.tst.fyugp_cms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String courseCode;
    private String courseDescription;
    private String courseDuration;
    private String courseType;
    private String courseMode;
    private String courseCredit;
    @ManyToMany
    @JoinTable(
            name = "course_programme",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "programme_id")
    )
    private List<Programme> programme;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentProfile> studentProfiles;

}
