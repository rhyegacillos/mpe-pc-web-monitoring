package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.Hdd;
import com.mpe.pc.webmonitoring.repositories.HddRepository;
import com.mpe.pc.webmonitoring.services.HddServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class HddServiceImplTest {

    private final static String MODULE_NO = "HDD123456";

    HddServiceImpl hddService;

    @Mock
    HddRepository hddRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        hddService = new HddServiceImpl(hddRepository);
    }

    @Test
    public void getAllHddRecords(Pageable pageable) throws Exception {

        Hdd hdd = new Hdd();
        hdd.setModuleNo(MODULE_NO);
        hdd.setFlag(1);

        HashSet<Hdd> hddHashSet = new HashSet<>();
        hddHashSet.add(hdd);

        //hddRepository.save(hdd);
        Page<Hdd> hddPage = null;

        when(hddService.getAllHddRecords(hdd.getFlag(), pageable)).thenReturn(hddPage);

    }

    @Test
    public void saveHdd() throws Exception {
    }

    @Test
    public void getHdd() throws Exception {
    }

    @Test
    public void getHddList() throws Exception {
    }

    @Test
    public void deleteHdd() throws Exception {
    }

}