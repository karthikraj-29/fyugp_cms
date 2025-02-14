package com.tst.fyugp_cms.dto;


import com.tst.fyugp_cms.model.College;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class UniversityDto {
    private String universityName;
    private String universityCode;
    private String universityDescription;
    private String universityLocation;
    private String universityEmail;
    private String universityPhone;
    private String universityWebsite;
}
