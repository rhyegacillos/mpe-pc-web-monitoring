package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.PcEndorse;
import com.mpe.pc.webmonitoring.repositories.PcEndorsementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcEndorsementServiceImpl implements PcEndorsementService {

    private PcEndorsementRepository pcEndorsementRepository;

    @Autowired
    public PcEndorsementServiceImpl(PcEndorsementRepository pcEndorsementRepository) {
        this.pcEndorsementRepository = pcEndorsementRepository;
    }


    @Override
    public Page<PcEndorse> getAllPcEndorseRecords(Pageable pageable) {
        return pcEndorsementRepository.findAll(pageable);
    }

    @Override
    public PcEndorse getPcEndorse(String controlNo) {
        return pcEndorsementRepository.findOne(controlNo);
    }

    @Override
    public void save(PcEndorse pcEndorse) {
        pcEndorsementRepository.save(pcEndorse);
    }

    @Override
    public void delete(PcEndorse pcEndorse) {
        pcEndorsementRepository.delete(pcEndorse);
    }

    @Override
    public List<PcEndorse> getPcEndorseList() {
        return pcEndorsementRepository.findAll();
    }
}
