package com.mpe.pc.webmonitoring.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "pc_endorsement")
public class PcEndorse {

    @Id
    @Column(name = "hdd_control_no")
    @NotNull(message = "Invalid HDD Control Number")
    @Size(min = 10, max = 10, message = "Invalid HDD Control Number, it must have 10 characters")
    private String controlNo;

    @Column(name = "date_endorsed")
    @Size(min = 10, max = 10, message = "Invalid Date")
    private String dateEndorsed;

    @Column(name = "line")
    @NotBlank(message = "No Specified Line")
    private String line;

    @Column(name = "process")
    @NotBlank(message = "No Specified Process")
    private String process;

    @Column(name = "ng_code")
    @NotBlank(message = "No Specified NG Code")
    private String ngCode;

    @Column(name = "source")
    @NotBlank(message = "No Specified Source")
    private String source;

    @Column(name = "endorsed_by")
    @NotBlank(message = "No Specified Endorsed By")
    private String endorsedBy;

    @Column(name = "remarks")
    @NotBlank(message = "No Specified Remarks")
    private String remarks;

    public void setControlNo(String controlNo) {
        this.controlNo = controlNo.trim();
    }
}
