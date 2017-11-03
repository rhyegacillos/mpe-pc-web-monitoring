package com.mpe.pc.webmonitoring.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "pc_spare")
public class PCSpare extends PCInfo {

    @NotBlank(message = "No Specified Repaired By")
    @Column(name = "repaired_by")
    private String repairedBy;

    @NotBlank(message = "No Specified Location")
    @Column(name = "location")
    private String location;

    @Column(name = "withdrawn_by")
    private String withdrawnBy;

    @Column(name = "use_for")
    private String useFor;

    @Column(name="date_withdrawn")
    private String dateWithdrawn;

    @Column(name = "flag")
    private int flag;

    public PCSpare(String controlNum, String repairedBy, String date, String location, int flag){
        super(controlNum, date);
        this.repairedBy = repairedBy;
        this.location = location;
        this.flag = flag;
    }
}
