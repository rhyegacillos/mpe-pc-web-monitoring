package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.NgPcParts;
import com.mpe.pc.webmonitoring.repositories.NgPcPartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NgPcPartsServiceImpl implements NgPcPartsService {

    private final NgPcPartsRepository ngPcPartsRepository;

    @Autowired
    public NgPcPartsServiceImpl(NgPcPartsRepository ngPcPartsRepository) {
        this.ngPcPartsRepository = ngPcPartsRepository;
    }

    @Override
    public Page<NgPcParts> getAllNgPartsRecords(Pageable pageable) {
        return ngPcPartsRepository.findAll(pageable);
    }

    @Override
    public void saveNgPcParts(NgPcParts ngPcParts) {
        if(ngPcParts.getId() == null) {
            ngPcPartsRepository.save(ngPcParts);
        } else {
            NgPcParts ngPcPartsTemp = ngPcPartsRepository.findOne(ngPcParts.getId());

            //ngPcPartsTemp.setId(ngPcParts.getId());
            ngPcPartsTemp.setBrand(ngPcParts.getBrand());
            ngPcPartsTemp.setDateDefect(ngPcParts.getDateDefect());
            ngPcPartsTemp.setDatePurchased(ngPcParts.getDatePurchased());
            ngPcPartsTemp.setDefect(ngPcParts.getDefect());
            ngPcPartsTemp.setDefectiveParts(ngPcParts.getDefectiveParts());
            ngPcPartsTemp.setDisposedBy(ngPcParts.getDisposedBy());
            ngPcPartsTemp.setInstalledDate(ngPcParts.getInstalledDate());
            ngPcPartsTemp.setLifespan(ngPcParts.getLifespan());
            ngPcPartsTemp.setMonth(ngPcParts.getMonth());
            ngPcPartsTemp.setPcName(ngPcParts.getPcName());
            ngPcPartsTemp.setProcess(ngPcParts.getProcess());
            ngPcPartsTemp.setRemarks(ngPcParts.getRemarks());
            ngPcPartsTemp.setSerialNumber(ngPcParts.getSerialNumber());
            ngPcPartsTemp.setSource(ngPcParts.getSource());

            ngPcPartsRepository.save(ngPcPartsTemp);
        }
    }

    @Override
    public NgPcParts getNgPcParts(String serial) {
        return ngPcPartsRepository.findBySerialNumber(serial);
    }

    @Override
    public List<NgPcParts> getNgPcPartsList() {
        return ngPcPartsRepository.findAll();
    }

    @Override
    public void deleteNgPcParts(NgPcParts ngPcParts) {
        ngPcPartsRepository.delete(ngPcParts);
    }
}
