package com.mpe.pc.webmonitoring.domains;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity(name = "pc_repair")
public class PCRepair {

    @Id
    @Column(name = "control_number")
    @NotNull(message = "Invalid HDD Control Number")
    @Size(min = 10, max = 10, message = "Invalid HDD Control Number, it must have 10 characters")
    private String controlNumber;

    @Column(name = "mac")
    @NotNull(message = "Invalid MAC Address")
    @Size(min=12, max = 12, message = "Invalid MAC Address, it must have 12 characters")
    private String mac;

    @Column(name = "mobo")
    private String mobo;

    @Column(name = "source")
    private String source;

    @Column(name = "station")
    private String station;

    @Column(name = "pc_name")
    private String pcName;

    @Column(name = "ng_description")
    private String ngDescription;

    @Column(name = "weak_component")
    private String weakComponent;

    @Column(name = "finding")
    private String finding;

    @Column(name = "action_taken")
    private String actionTaken;

    @Column(name = "hdd_orientation")
    private String hddOrientation;

    @Column(name = "hdd_installed")
    private String hddInstalled;

    @Column(name = "repaired_by")
    private String repairedBy;

    @Column(name = "month")
    private String month;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "change_fan")
    private int changeFan;

    @Column(name = "removed_intake_fan")
    private int removedIntakeFan;

    @Column(name = "ng_occurrence")
    private int ngOccurrence;

    @Column(name = "pm_date")
    private String pmDate;

    @Column(name = "date_repair_start")
    private String dateRepairStart;

    @Column(name = "date_repair_end")
    private String dateRepairEnd;

    @Column(name = "date_endorsed")
    private String dateEndorsed;

    public void setControlNumber(String controlNumber) {
        this.controlNumber = controlNumber.trim();
    }
}
