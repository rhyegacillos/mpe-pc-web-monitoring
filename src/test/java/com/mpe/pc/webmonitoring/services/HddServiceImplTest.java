package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.Hdd;
import com.mpe.pc.webmonitoring.repositories.HddRepository;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
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

    @Test
    public void saveHdd_test() throws Exception {
        Hdd hdd = new Hdd();
        hdd.setModuleNo(MODULE_NO);

        when(hddRepository.save(any(Hdd.class))).thenReturn(hdd);

        //Hdd getHdd = hddRepository.findOne(MODULE_NO);

        assertNotNull(hddRepository.findOne(MODULE_NO));

        verify(hddRepository, times(1)).save(any(Hdd.class));
    }

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

    @Test
    public void getHddList() throws Exception {
        Hdd hdd = new Hdd();
        hdd.setModuleNo(MODULE_NO);
        hdd.setFlag(1);
        List<Hdd> hddList = new ArrayList<>();
        hddList.add(hdd);

        when(hddService.getHddList(1)).thenReturn(hddList);

        List<Hdd> hddListWithFlagOne = hddRepository.findByFlag(1);
        List<Hdd> hddListWihtFlagZero = hddRepository.findByFlag(0);

        assertEquals(hddListWithFlagOne.size(), 1);
        assertEquals(hddListWihtFlagZero.size(), 0);
        verify(hddRepository, times(1)).findByFlag(1);
        verify(hddRepository, times(1)).findByFlag(0);
    }

    @Test
    public void deleteHdd() throws Exception {
        Hdd hdd = new Hdd();
        hdd.setModuleNo(MODULE_NO);

        hddRepository.save(hdd);

        hddService.deleteHdd(hdd);

        verify(hddRepository, times(1)).delete(any(Hdd.class));
    }

}