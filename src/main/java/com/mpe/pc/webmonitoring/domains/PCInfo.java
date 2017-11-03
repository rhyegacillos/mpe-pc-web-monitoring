package com.mpe.pc.webmonitoring.domains;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class PCInfo {

    @Id
    @Column(name = "control_number")
    @Size(min = 10, max = 10, message = "Invalid Control Number")
    private String controlNumber;

    @Size(min=10, max = 10, message = "Invalid Date Repaired")
    @Column(name = "date_repaired")
    private String date;

    public PCInfo(String controlNumber, String date) {
        this.controlNumber = controlNumber;
        this.date = date;
    }
}
