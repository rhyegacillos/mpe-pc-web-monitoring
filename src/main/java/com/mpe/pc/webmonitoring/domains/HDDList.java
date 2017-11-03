package com.mpe.pc.webmonitoring.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Setter
@Getter
public class HDDList {

    Page<Hdd> hddPage;

}
