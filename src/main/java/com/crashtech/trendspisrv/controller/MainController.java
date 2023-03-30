package com.crashtech.trendspisrv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crashtech.trendspisrv.modal.Stocks;
import com.crashtech.trendspisrv.repository.StocksRepository;

@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	private StocksRepository stocksRepository;

	@PostMapping("/push/trend")
	public ResponseEntity<?> addStock(@RequestBody Stocks stocks) {
		Stocks save = this.stocksRepository.save(stocks);
		return ResponseEntity.ok(save);
	}
	
	@PostMapping("/push/trends")
    public ResponseEntity<List<Stocks>> addStocks(@RequestBody List<Stocks> stocks) {
        List<Stocks> savedStocks = stocksRepository.saveAll(stocks);
        return ResponseEntity.ok(savedStocks);
    }
	
	@GetMapping("/get/trends")
	public ResponseEntity<?> getStocks() {
		return ResponseEntity.ok(this.stocksRepository.findAll());
	}

}
