package com.tst.fyugp_cms.dto;

import com.tst.fyugp_cms.model.University;
import jakarta.persistence.*;

public class CollegeDto {
    private String collegeName;
    private String collegeCode;
    private String collegeDescription;
    private String collegeLocation;
    private String collegeEmail;
    private String collegePhone;
    private String collegeWebsite;
    private University university;
}
