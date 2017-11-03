package com.mpe.pc.webmonitoring.repositories;

import com.mpe.pc.webmonitoring.domains.Hdd;
import com.mpe.pc.webmonitoring.domains.NgPcParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgPcPartsRepository extends JpaRepository<NgPcParts, Long> {
    public NgPcParts findBySerialNumber(String serial);
}
