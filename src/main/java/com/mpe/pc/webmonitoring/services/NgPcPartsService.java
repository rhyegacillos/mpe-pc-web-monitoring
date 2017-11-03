package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.NgPcParts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NgPcPartsService {
    Page<NgPcParts> getAllNgPartsRecords(Pageable pageable);
    void saveNgPcParts(NgPcParts ngPcParts);
    NgPcParts getNgPcParts(String serial);
    List<NgPcParts> getNgPcPartsList();
    void deleteNgPcParts(NgPcParts ngPcParts);
}
