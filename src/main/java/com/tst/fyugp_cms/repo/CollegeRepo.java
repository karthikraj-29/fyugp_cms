package com.tst.fyugp_cms.repo;

import com.tst.fyugp_cms.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepo  extends JpaRepository<College, Long> {
}
