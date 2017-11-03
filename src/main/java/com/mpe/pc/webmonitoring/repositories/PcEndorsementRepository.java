package com.mpe.pc.webmonitoring.repositories;

import com.mpe.pc.webmonitoring.domains.PcEndorse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcEndorsementRepository extends JpaRepository<PcEndorse, String> {
}
