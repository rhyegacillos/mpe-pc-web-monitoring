package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.Hdd;
import com.mpe.pc.webmonitoring.repositories.HddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HddServiceImpl implements HddService {

    private final HddRepository hddRepository;

    @Autowired
    public HddServiceImpl(HddRepository hddRepository) {
        this.hddRepository = hddRepository;
    }

    @Override
    public Page<Hdd> getAllHddRecords(int flag, Pageable pageable) {

        return hddRepository.findByFlag(flag, pageable);
    }

    @Override
    public void saveHdd(Hdd hdd) {
        hddRepository.save(hdd);
    }

    @Override
    public Hdd getHdd(String moduleNo) {
        return hddRepository.findOne(moduleNo);
    }

    @Override
    public List<Hdd> getHddList(int flag) {
        return hddRepository.findByFlag(flag);
    }

    @Override
    public void deleteHdd(Hdd hdd) {
        hddRepository.delete(hdd);
    }
}
