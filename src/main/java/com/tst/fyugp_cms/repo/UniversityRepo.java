package com.tst.fyugp_cms.repo;

import com.tst.fyugp_cms.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversityRepo extends JpaRepository<University, Long> {

    Optional<University> findById(Long id);
}
