package com.mpe.pc.webmonitoring.repositories;

import com.mpe.pc.webmonitoring.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByFirstName(String name);
}
