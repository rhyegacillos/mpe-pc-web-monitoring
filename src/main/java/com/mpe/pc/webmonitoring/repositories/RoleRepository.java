package com.mpe.pc.webmonitoring.repositories;

import com.mpe.pc.webmonitoring.domains.User;
import com.mpe.pc.webmonitoring.domains.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRoles, String> {

}
