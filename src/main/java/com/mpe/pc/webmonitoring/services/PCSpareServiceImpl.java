package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.NewSparePC;
import com.mpe.pc.webmonitoring.domains.PCSpare;
import com.mpe.pc.webmonitoring.repositories.NewSparePCRepository;
import com.mpe.pc.webmonitoring.repositories.PCSpareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PCSpareServiceImpl implements PCSpareService {
    private final PCSpareRepository pcSpareRepository;
    private final NewSparePCRepository newSparePCRepository;

    @Autowired
    public PCSpareServiceImpl(PCSpareRepository pcSpareRepository, NewSparePCRepository newSparePCRepository) {
        this.pcSpareRepository = pcSpareRepository;
        this.newSparePCRepository = newSparePCRepository;
    }

    // Repaired PC

    public List<PCSpare> getAllPcSpare(int flag) {
        return pcSpareRepository.findByFlag(flag);
    }

    public PCSpare getSparePC(String controlNum) {
        return pcSpareRepository.findOne(controlNum);
    }

    public void deleteSparePC(String controlNum) {
        pcSpareRepository.delete(controlNum);
    }

    public void addSparePC(PCSpare pcSpare) {
        pcSpareRepository.save(pcSpare);
    }

    @Override
    public Page<PCSpare> repairPCSpareRecords(int flag, Pageable pageable) {
        return pcSpareRepository.findByFlag(flag, pageable);
    }


    // New Spare PC
    public List<NewSparePC> getAllNewSpare(int flag) {
        return newSparePCRepository.findByFlag(flag);
    }

    @Override
    public Page<NewSparePC> newSpareRecords(int flag, Pageable pageable) {
        return newSparePCRepository.findByFlag(flag, pageable);
    }

    public NewSparePC getNewSparePC(String controlNum) {
        return newSparePCRepository.findByControlNum(controlNum);
    }

    public void addNewSparePC(NewSparePC newSparePC) {
        newSparePCRepository.save(newSparePC);
    }

    @Override
    public void deleteNewSparePc(NewSparePC newSparePC) {
        newSparePCRepository.delete(newSparePC);
    }
}
