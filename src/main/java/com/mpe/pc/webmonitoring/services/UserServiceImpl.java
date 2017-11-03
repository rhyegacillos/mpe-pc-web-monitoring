package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.User;
import com.mpe.pc.webmonitoring.domains.UserRoles;
import com.mpe.pc.webmonitoring.repositories.RoleRepository;
import com.mpe.pc.webmonitoring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User getUserDetails(String name) {
        return userRepository.findOne(name);
    }

    @Override
    public UserRoles getUserRole(String employeeId) {
        return roleRepository.findOne(employeeId);
    }

    @Override
    public void saveUser(User user, UserRoles userRoles) {
        userRepository.save(user);
        roleRepository.save(userRoles);

    }

    @Override
    public void deleteUser(User user, UserRoles userRoles) {
        if(!userRoles.getRoles().equals("ROLE_ADMIN")) {
            roleRepository.delete(userRoles);
            userRepository.delete(user);
        }
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
