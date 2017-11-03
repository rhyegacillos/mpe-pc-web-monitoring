package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.repositories.PCRepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mpe.pc.webmonitoring.domains.PCRepair;

import java.util.List;

@Service
public class PCRepairServiceImpl implements PCRepairService  {

    private final PCRepairRepository pcRepairRepository;

    @Autowired
    public PCRepairServiceImpl(PCRepairRepository pcRepairRepository) {
        this.pcRepairRepository = pcRepairRepository;
    }

    public void saveOrUpdate(PCRepair pcRepair) {
        pcRepairRepository.save(pcRepair);
    }

    public PCRepair findByControlNum(String controlNum) {
        return pcRepairRepository.findOne(controlNum);
    }

    public Page<PCRepair> getAllRecords(Pageable pageable) {
        return pcRepairRepository.findAll(pageable);
    }

    @Override
    public List<PCRepair> getAllRecords() {
        return pcRepairRepository.findAll();
    }

    @Override
    public void deletePcRepair(PCRepair pcRepair) {
        pcRepairRepository.delete(pcRepair);
    }
}
