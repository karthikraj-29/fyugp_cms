package com.tst.fyugp_cms.repo;


import com.tst.fyugp_cms.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepo extends JpaRepository<StudentProfile, Long> {
}
