package com.mpe.pc.webmonitoring.repositories;

import com.mpe.pc.webmonitoring.domains.NewSparePC;
import com.mpe.pc.webmonitoring.domains.PCSpare;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PCSpareRepository extends JpaRepository<PCSpare, String> {

    Page<PCSpare> findByFlag(int flag, Pageable pageable);
    List<PCSpare> findByFlag(int flag);

}
