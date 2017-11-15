package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.HDDList;
import com.mpe.pc.webmonitoring.domains.Hdd;
import com.mpe.pc.webmonitoring.repositories.HddRepository;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class HddServiceImplTest {

    private final static String MODULE_NO = "HDD1234567";

    HddService hddService;

    @Mock
    HddRepository hddRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        hddService = new HddServiceImpl(hddRepository);

    }

    @Test
    public void getAllHddRecords() throws Exception {

        Pageable pageable = mock(Pageable.class);

        Hdd hdd1 = new Hdd();
        Hdd hdd2 = new Hdd();
        Hdd hdd3 = new Hdd();
        Hdd hdd4 = new Hdd();
        hdd1.setModuleNo("HDD2345679");
        hdd2.setModuleNo("HDD2345678");
        hdd3.setModuleNo("HDD2345671");
        hdd4.setModuleNo("HDD2345672");
        hdd1.setFlag(1);
        hdd2.setFlag(0);
        hdd3.setFlag(1);
        hdd4.setFlag(1);

        List<Hdd> hddList_flg1 = new ArrayList<>();
        List<Hdd> hddList_flg0 = new ArrayList<>();
        hddList_flg1.add(hdd1);
        hddList_flg1.add(hdd2);
        hddList_flg0.add(hdd3);
        hddList_flg1.add(hdd4);

        Page<Hdd> hddPage_flg1 = new PageImpl<>(hddList_flg1);
        Page<Hdd> hddPage_flg0 = new PageImpl<>(hddList_flg0);

        when(hddRepository.findByFlag(1, pageable)).thenReturn(hddPage_flg1);
        when(hddRepository.findByFlag(0, pageable)).thenReturn(hddPage_flg0);

        assertEquals(1, hddService.getAllHddRecords(1, pageable).getTotalPages());
        assertEquals(1, hddService.getAllHddRecords(0, pageable).getNumberOfElements());
        assertEquals(3, hddService.getAllHddRecords(1, pageable).getNumberOfElements());

        verify(hddRepository, times(2)).findByFlag(1, pageable);
        verify(hddRepository, times(1)).findByFlag(0, pageable);
    }

    @Test
    public void saveHdd() throws Exception {

        Hdd hdd = new Hdd();
        hdd.setModuleNo(MODULE_NO);

        when(hddRepository.findOne(anyString())).thenReturn(hdd);

        hddService.saveHdd(hdd);

        Hdd getHdd = hddRepository.findOne(MODULE_NO);

        assertNotNull(hddRepository.findOne(MODULE_NO));
        assertEquals(hdd.getModuleNo(), getHdd.getModuleNo());

        verify(hddRepository, times(1)).save(any(Hdd.class));
        verify(hddRepository, never()).delete(anyString());
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