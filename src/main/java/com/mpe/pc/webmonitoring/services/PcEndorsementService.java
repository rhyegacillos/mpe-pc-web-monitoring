package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.PcEndorse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PcEndorsementService {

    Page<PcEndorse> getAllPcEndorseRecords(Pageable pageable);
    PcEndorse getPcEndorse(String controlNo);
    void save(PcEndorse pcEndorse);
    void delete(PcEndorse pcEndorse);
    List<PcEndorse> getPcEndorseList();
}
