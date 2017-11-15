package com.mpe.pc.webmonitoring.services;

import com.mpe.pc.webmonitoring.domains.NgPcParts;
import com.mpe.pc.webmonitoring.repositories.NgPcPartsRepository;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class NgPcPartsServiceImplTest {

    final static String SERIAL_NUMBER = "123456";

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

        Pageable pageable = mock(Pageable.class);

        NgPcParts ngPcParts1 = new NgPcParts();
        NgPcParts ngPcParts2 = new NgPcParts();

        List ngPcPartsList = new ArrayList();
        ngPcPartsList.add(ngPcParts1);
        ngPcPartsList.add(ngPcParts2);

        Page<NgPcParts> ngPcPartsPage = new PageImpl<NgPcParts>(ngPcPartsList);

        when(ngPcPartsRepository.findAll(pageable)).thenReturn(ngPcPartsPage);

        assertNotNull(ngPcPartsService.getAllNgPartsRecords(pageable));
        assertEquals(2, ngPcPartsService.getAllNgPartsRecords(pageable).getTotalElements());

        verify(ngPcPartsRepository, times(2)).findAll(pageable);
    }

    @Test
    public void saveNgPcParts() throws Exception {
        NgPcParts ngPcParts = new NgPcParts();
        ngPcParts.setId(2L);

        when(ngPcPartsRepository.findOne(2L)).thenReturn(ngPcParts);

        ngPcParts.setSerialNumber(SERIAL_NUMBER);

        ngPcPartsService.saveNgPcParts(ngPcParts);

        NgPcParts getNgPcParts = ngPcPartsRepository.findOne(2L);

        assertNotNull(getNgPcParts);
        assertEquals(2L, getNgPcParts.getId().longValue());
        assertEquals(SERIAL_NUMBER,getNgPcParts.getSerialNumber().toString());

        verify(ngPcPartsRepository, times(1)).save(any(NgPcParts.class));
        verify(ngPcPartsRepository, times(2)).findOne(anyLong());
    }

    @Test
    public void getNgPcParts() throws Exception {
        NgPcParts ngPcParts = new NgPcParts();
        ngPcParts.setSerialNumber(SERIAL_NUMBER);
        ngPcParts.setId(1L);

        when(ngPcPartsRepository.findBySerialNumber(anyString())).thenReturn(ngPcParts);

        NgPcParts getNgPcParts = ngPcPartsService.getNgPcParts(SERIAL_NUMBER);

        assertNotNull(getNgPcParts);
        assertEquals(1L, getNgPcParts.getId().longValue());

        verify(ngPcPartsRepository, times(1)).findBySerialNumber(anyString());
        verify(ngPcPartsRepository, never()).findAll();
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