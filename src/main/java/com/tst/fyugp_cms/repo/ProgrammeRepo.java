package com.tst.fyugp_cms.repo;

import com.tst.fyugp_cms.model.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammeRepo extends JpaRepository<Programme, Long> {
}
