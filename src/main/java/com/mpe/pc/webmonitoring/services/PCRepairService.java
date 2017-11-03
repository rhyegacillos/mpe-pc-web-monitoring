package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.PCRepair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PCRepairService {

    void saveOrUpdate(PCRepair pcRepair);
    PCRepair findByControlNum(String controlNum);
    Page<PCRepair> getAllRecords(Pageable pageable);
    List<PCRepair> getAllRecords();
    void deletePcRepair(PCRepair pcRepair);
}
