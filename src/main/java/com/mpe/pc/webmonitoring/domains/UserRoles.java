package com.mpe.pc.webmonitoring.domains;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "authorities")
public class UserRoles {

    @Id
    @Column(name = "username")
    private String employeeId;

    @Column(name = "authority")
    private String roles;

}
