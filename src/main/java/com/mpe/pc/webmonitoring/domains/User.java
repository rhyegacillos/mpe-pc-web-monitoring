package com.mpe.pc.webmonitoring.domains;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity(name = "users")
public class User {

    @Id
    @Column(name = "username")
    @NotBlank
    private String employeeId;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    @Column(name = "enabled")
    private int enabled = 1;

}
