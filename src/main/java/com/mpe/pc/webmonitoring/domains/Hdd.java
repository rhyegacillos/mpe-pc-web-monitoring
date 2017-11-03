package com.mpe.pc.webmonitoring.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "hdd_inventory")
public class Hdd {

    @Id
    @Column(name = "module_no")
    @NotBlank(message = "Module Number is empty")
    private String moduleNo;

    @Column(name = "hdd_size")
    private String hddSize;

    @NotBlank(message = "No Brand Specified")
    @Column(name = "brand")
    private String brand;

    @NotBlank(message = "No Purpose Specified")
    @Column(name = "purpose")
    private String purpose;

    @Column(name = "date_withdrawn")
    private String dateWithdrawn;

    @Column(name = "withdrawn_by")
    private String withdrawnBy;

    @Column(name = "use_for")
    private String useFor;

    @Column(name = "mac")
    private String mac;

    @Column(name = "hdd_no")
    private String hddNo;

    @Column(name = "line_installed")
    private String lineInstalled;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "flag")
    private int flag;
}
