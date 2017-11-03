package com.mpe.pc.webmonitoring.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@Entity(name ="new_pc_spare")
public class NewSparePC {

    @Id
    @Column(name = "mac")
    @Size(min = 12, max = 12, message = "Invalid MAC Address")
    private String mac;

    @Column(name = "control_number")
    private String controlNum;

    @NotBlank(message = "No Specified Purpose")
    @Column(name = "purpose")
    private String purpose;

    @NotBlank(message = "No Specified Power Supply")
    @Column(name = "power_supply")
    private String powerSupply;

    @NotBlank(message = "No Specified Intake Fan")
    @Column(name = "intake")
    private String intake;

    @NotBlank(message = "No Specified Exhaust Fan")
    @Column(name = "exhaust")
    private String exhaust;

    @Column(name = "withdrawn_by")
    private String withdrawnBy;

    @Column(name = "use_for")
    private String useFor;

    @Column(name="date_withdrawn")
    private String dateWithdrawn;

    @Column(name="line_installed")
    private String lineInstalled;

    @Column(name = "flag")
    private int flag;
}
