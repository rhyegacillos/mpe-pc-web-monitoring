package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.Hdd;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HddService {

    Page<Hdd> getAllHddRecords(int flag, Pageable pageable);
    void saveHdd(Hdd hdd);
    Hdd getHdd(String moduleNo);
    List<Hdd> getHddList(int flag);
    void deleteHdd(Hdd hdd);
}
