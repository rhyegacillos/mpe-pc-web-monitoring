package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.NgPcParts;
import com.mpe.pc.webmonitoring.repositories.NgPcPartsRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NgPcPartsServiceImplTest {

    @InjectMocks
    NgPcPartsServiceImpl ngPcPartsService;

    @Mock
    NgPcPartsRepository ngPcPartsRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getAllNgPartsRecords() throws Exception {
    }

    @Test
    public void saveNgPcParts() throws Exception {
    }

    @Test
    public void getNgPcParts() throws Exception {

    }

    @Test
    public void getNgPcPartsList() throws Exception {
        NgPcParts ngPcParts = new NgPcParts();
        List ngPcPartsList = new ArrayList();
        ngPcPartsList.add(ngPcParts);

        when(ngPcPartsService.getNgPcPartsList()).thenReturn(ngPcPartsList);

        List<NgPcParts> getNgPcPartsList = ngPcPartsRepository.findAll();

        assertEquals(getNgPcPartsList.size(), 1);

        verify(ngPcPartsRepository, times(1)).findAll();
    }

    @Test
    public void deleteNgPcParts() throws Exception {
        NgPcParts ngPcParts = new NgPcParts();

        ngPcPartsRepository.save(ngPcParts);

        ngPcPartsService.deleteNgPcParts(ngPcParts);

        verify(ngPcPartsRepository, times(1)).delete(any(NgPcParts.class));
    }

}