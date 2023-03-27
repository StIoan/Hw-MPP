package com.hw3.hw3;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.hw3.hw3.Exception.Exception;
import com.hw3.hw3.Model.Owner;
import com.hw3.hw3.Repository.OwnerRepo;
import com.hw3.hw3.Service.OwnerService;

@RunWith(MockitoJUnitRunner.class)
public class Hw3ApplicationTests {

	@InjectMocks
    private OwnerService ownerService;
    @Mock
    private OwnerRepo ownerRepo;

    @Test
    public void findAllTest() throws Exception {
        when(ownerRepo.findAll()).thenReturn(Stream
        .of(new Owner(1, "a", "a", 180, 80, "d"), 
        new Owner(2, "b", "b", 160, 60, "c"))
        .collect(Collectors.toList()));
        assertEquals(2, ownerService.getAllOwners().size());
    }

    @Test
    public void findByHeightGreaterThan() throws Exception {
        when(ownerRepo.findByHeightGreaterThan(170)).thenReturn(Stream
        .of(new Owner(1, "a", "a", 180, 80, "d"))
        .collect(Collectors.toList()));
        assertEquals(1, ownerRepo.findByHeightGreaterThan(170).size());
    }

	@Test
    public void findByWeightGreaterThan() throws Exception {
        when(ownerRepo.findByWeightGreaterThan(65)).thenReturn(Stream
        .of(new Owner(1, "a", "a", 180, 80, "d"))
        .collect(Collectors.toList()));
        assertEquals(1, ownerRepo.findByWeightGreaterThan(65).size());
    }
}
