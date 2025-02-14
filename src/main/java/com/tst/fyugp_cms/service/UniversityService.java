package com.tst.fyugp_cms.service;

import com.tst.fyugp_cms.dto.UniversityDto;
import org.springframework.http.ResponseEntity;

public interface UniversityService {

    public UniversityDto addUniversity(UniversityDto universityDto);
    public ResponseEntity<?> getAllUniversities();
    public UniversityDto getUniversityById(Long id);
    public UniversityDto updateUniversity(UniversityDto universityDto , Long id);
    public boolean deleteUniversity(Long id);
}
