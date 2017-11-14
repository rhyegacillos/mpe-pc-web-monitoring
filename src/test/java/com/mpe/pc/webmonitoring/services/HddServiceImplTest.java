package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.Hdd;
import com.mpe.pc.webmonitoring.repositories.HddRepository;
import com.mpe.pc.webmonitoring.services.HddServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.*;

public class HddServiceImplTest {

    private final static String MODULE_NO = "HDD1234567";

    @InjectMocks
    HddServiceImpl hddService;

    @Mock
    HddRepository hddRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void getAllHddRecords(Pageable pageable) throws Exception {
//
//        Hdd hdd = new Hdd();
//        hdd.setModuleNo(MODULE_NO);
//        hdd.setFlag(1);
//
//        HashSet<Hdd> hddHashSet = new HashSet<>();
//        hddHashSet.add(hdd);
//
//        //hddRepository.save(hdd);
//        Page<Hdd> hddPage = null;
//
//        when(hddService.getAllHddRecords(hdd.getFlag(), pageable)).thenReturn(hddPage);
//
//    }

//    @Test
//    @Ignore
//    public void saveHdd() throws Exception {
//    }

    @Test
    public void getHdd() throws Exception {

        when(hddRepository.findOne(anyString())).thenReturn(new Hdd());

        Hdd hdd = new Hdd();
        hdd.setModuleNo(MODULE_NO);
        hddService.saveHdd(hdd);

        assertNotNull(hddService.getHdd(MODULE_NO));

        verify(hddRepository, times(1)).findOne(anyString());
        verify(hddRepository, never()).findAll();
    }

//    @Test
//    @Ignore
//    public void getHddList() throws Exception {
//    }
//
    @Test
    @Ignore
    public void deleteHdd() throws Exception {
        Hdd hdd = new Hdd();
        hdd.setModuleNo(MODULE_NO);

        hddRepository.save(hdd);

        hddService.deleteHdd(hdd);

        verify(hddRepository, times(1)).delete(any(Hdd.class));
    }

}