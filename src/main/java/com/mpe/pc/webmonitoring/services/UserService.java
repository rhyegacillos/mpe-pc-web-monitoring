package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.User;
import com.mpe.pc.webmonitoring.domains.UserRoles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User getUserDetails(String name);

    UserRoles getUserRole(String employeeId);

    void saveUser(User user, UserRoles userRoles);

    void deleteUser(User user, UserRoles userRoles);

    List<User> getUserList();

    Page<User> getAllUsers(Pageable pageable);

}
