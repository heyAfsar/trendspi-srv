package com.crashtech.trendspisrv.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crashtech.trendspisrv.modal.Stocks;
import com.crashtech.trendspisrv.repository.StocksRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class MainControllerTest {
	
    @InjectMocks
    private MainController mainController;
    
    @Mock
    private StocksRepository stocksRepository;
    
    private MockMvc mockMvc;
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }
    
    @Test
    void testGetStocks() throws Exception {
    	Stocks stock = new Stocks("1", "AAPL", 4, null, null, 0, null, null, null);
    	stock.setId("1");
    	stock.setName("AAPL");
    	stock.setStars(4);
    	List<Stocks> stocks = new ArrayList<>();
    	stocks.add(stock);
    	
        when(stocksRepository.findAll()).thenReturn(stocks);
        
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/get/trends")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        assertEquals(objectMapper.writeValueAsString(stocks), result.getResponse().getContentAsString());
    }
}
