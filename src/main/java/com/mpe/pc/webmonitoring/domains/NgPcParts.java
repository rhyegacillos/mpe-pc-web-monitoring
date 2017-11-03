package com.mpe.pc.webmonitoring.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="ng_pc_parts_table")
public class NgPcParts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "month")
    private String month;

    @Size(min=10, max = 10, message = "Invalid Date Defect")
    @Column(name = "date_defect")
    private String dateDefect;

    @Column(name = "source")
    private String source;

    @NotBlank(message = "No Specified Defective Parts")
    @Column(name = "defective_parts")
    private String defectiveParts;

    @Column(name = "brand")
    private String brand;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "process")
    private String process;

    @Column(name = "pc_name")
    private String pcName;

    @NotBlank(message = "No Specified Defect")
    @Column(name = "defect")
    private String defect;

    @Column(name = "date_purchased")
    private String datePurchased;

    @Column(name = "installed_date")
    private String installedDate;

    @Column(name = "lifespan")
    private String lifespan;

    @NotBlank(message = "No Specified Disposed By")
    @Column(name = "disposed_by")
    private String disposedBy;

    @Column(name = "remarks")
    private String remarks;
}
