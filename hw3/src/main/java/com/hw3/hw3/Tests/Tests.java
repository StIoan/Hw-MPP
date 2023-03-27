package com.hw3.hw3.Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.hw3.hw3.Exception.Exception;
import com.hw3.hw3.Model.Owner;
import com.hw3.hw3.Repository.OwnerRepo;
import com.hw3.hw3.Service.OwnerService;

@RunWith(MockitoJUnitRunner.class)
public class Tests {
    @InjectMocks
    private OwnerService ownerService;
    @Mock
    private OwnerRepo ownerRepo;

    @Test
    void findAllTest() throws Exception {
        when(ownerRepo.findAll()).thenReturn(Stream
        .of(new Owner(1, "a", "a", 180, 80, "d"), 
        new Owner(2, "b", "b", 160, 60, "c"))
        .collect(Collectors.toList()));
        assertEquals(2, ownerService.getAllOwners().size());
    }

    @Test
    void findByPriceGreaterThan() throws Exception {
        when(ownerRepo.findByHeightGreaterThan(170)).thenReturn(Stream
        .of(new Owner(1, "a", "a", 180, 80, "d"))
        .collect(Collectors.toList()));
        assertEquals(2, ownerService.getAllOwners().size());
    }
}
