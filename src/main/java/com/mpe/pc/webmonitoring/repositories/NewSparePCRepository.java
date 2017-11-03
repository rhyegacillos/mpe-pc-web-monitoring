package com.mpe.pc.webmonitoring.repositories;

import com.mpe.pc.webmonitoring.domains.NewSparePC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewSparePCRepository extends JpaRepository<NewSparePC, String> {

//    List<NewSparePC> getAllRecords();
//    NewSparePC findByControlNum(String controlNum);
//    void addNewSparePC(NewSparePC newSparePC);

    Page<NewSparePC> findByFlag(int flag, Pageable pageable);
    List<NewSparePC> findByFlag(int flag);

}
