package com.mpe.pc.webmonitoring.repositories;

import com.mpe.pc.webmonitoring.domains.Hdd;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HddRepository extends JpaRepository<Hdd, String> {
    Page<Hdd> findByFlag(int flag, Pageable pageable);
    List<Hdd> findByFlag(int flag);
}
