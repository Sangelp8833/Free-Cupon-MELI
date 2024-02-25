package com.freecupon.MELI.helpers.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TotalCalculationsTest {


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @InjectMocks
    private TotalCalculations totalCalculations;

    @Test
    void total() {

        Integer qOfElements  = 5;
        Double cuponValue = 500D;
        List<Double> prices = new ArrayList<>();
        prices.add(100D);
        prices.add(210D);
        prices.add(260D);
        prices.add(80D);
        prices.add(90D);

        int[] visited = new int[5];


        double response = totalCalculations.total(qOfElements,cuponValue,prices,visited);
        Assertions.assertEquals(480,response);
    }
}