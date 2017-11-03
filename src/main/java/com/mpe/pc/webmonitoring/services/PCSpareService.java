package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.NewSparePC;
import com.mpe.pc.webmonitoring.domains.PCSpare;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PCSpareService {
    List<PCSpare> getAllPcSpare(int flag);
    PCSpare getSparePC(String controlNum);
    void deleteSparePC(String controlNum);
    void addSparePC(PCSpare pcSpare);
    Page<PCSpare> repairPCSpareRecords(int flag, Pageable pageable);

    List<NewSparePC> getAllNewSpare(int flag);
    Page<NewSparePC> newSpareRecords(int flag, Pageable pageable);
    NewSparePC getNewSparePC(String controlNum);
    void addNewSparePC(NewSparePC newSparePC);
    void deleteNewSparePc(NewSparePC newSparePC);
}
