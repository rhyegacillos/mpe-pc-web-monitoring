package com.mpe.pc.webmonitoring.repositories;

import com.mpe.pc.webmonitoring.domains.PCRepair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PCRepairRepository extends JpaRepository<PCRepair, String> {

}
