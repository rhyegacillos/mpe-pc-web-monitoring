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
    List<Hdd> findByModuleNoContainingOrHddSizeContainingOrBrandContainingOrPurposeContaining(String module, String hddSize, String brand, String purpose);

    Page<Hdd> findByDateWithdrawnIsNull(Pageable pageable);
    Page<Hdd> findByDateWithdrawnIsNotNull(Pageable pageable);
    Page<Hdd> findByFlag(int flag, Pageable pageable);
    List<Hdd> findByFlag(int flag);



//    @Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
//    User findByLastnameOrFirstname(@Param("lastname") String lastname,
//                                   @Param("firstname") String firstname);
}
