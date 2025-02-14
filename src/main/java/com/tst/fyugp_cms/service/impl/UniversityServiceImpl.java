package com.tst.fyugp_cms.service.impl;

import com.tst.fyugp_cms.dto.UniversityDto;
import com.tst.fyugp_cms.exception.UniversityNotFoundException;
import com.tst.fyugp_cms.model.University;
import com.tst.fyugp_cms.repo.UniversityRepo;
import com.tst.fyugp_cms.service.UniversityService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepo universityRepo;
    private final ModelMapper modelMapper;
    private UniversityRepo universityRepo1;

    public UniversityServiceImpl(UniversityRepo universityRepo, ModelMapper modelMapper) {
        this.universityRepo = universityRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UniversityDto addUniversity(UniversityDto universityDto) {
        University university = modelMapper.map(universityDto, University.class);
        universityRepo.save(university);
        return modelMapper.map(university, UniversityDto.class);
    }
    @Override
    public ResponseEntity<?> getAllUniversities() {
        List<University> universities = universityRepo.findAll();
        List<UniversityDto> universityDtos = universities.stream()
                .map(university -> modelMapper.map(university,
                        UniversityDto.class))

                .collect(Collectors.toList());
        return ResponseEntity.ok(universityDtos);
    }

   @Override
   public UniversityDto getUniversityById(Long id) {
       Optional<University> universityOptional = universityRepo.findById(id);
       if (universityOptional.isPresent()) {
           return modelMapper.map(universityOptional.get(), UniversityDto.class);
       } else {
           throw new UniversityNotFoundException("University not found with id: " + id);
       }
   }

    @Override
    public UniversityDto updateUniversity(UniversityDto universityDto , Long id) {
        if (universityRepo.existsById(id)){
            University existingUniversity = universityRepo.findById(id).get();
            existingUniversity.setUniversityName(universityDto.getUniversityName());
            existingUniversity.setUniversityCode(universityDto.getUniversityCode());
            existingUniversity.setUniversityDescription(universityDto.getUniversityDescription());
            existingUniversity.setUniversityLocation(universityDto.getUniversityLocation());    
            existingUniversity.setUniversityEmail(universityDto.getUniversityEmail());
            existingUniversity.setUniversityPhone(universityDto.getUniversityPhone());
            existingUniversity.setUniversityWebsite(universityDto.getUniversityWebsite());
            universityRepo.save(existingUniversity);
            return modelMapper.map(existingUniversity, UniversityDto.class);
        } else {
            return null;
            
        }
    }
    @Override
    public boolean deleteUniversity(Long id) {
        if(universityRepo.existsById(id)){
            universityRepo.deleteById(id);
            return true;
        }
        return false;
    }

}