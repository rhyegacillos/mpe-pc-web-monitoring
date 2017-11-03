package com.mpe.pc.webmonitoring.domains;

import lombok.Data;

@Data
public class PCSample {
    private String pcType;
    private String mac;
    private String model;
}
