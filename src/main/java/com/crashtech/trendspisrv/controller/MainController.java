package com.crashtech.trendspisrv.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//Getting all Stocks
	@GetMapping("/get/trends")
	public ResponseEntity<?> getStocks() {
		return ResponseEntity.ok(this.stocksRepository.findAll());
	}

	//Posting one Stock
	@PostMapping("/push/trend")
	public ResponseEntity<?> addStock(@RequestBody Stocks stocks) {
		Stocks save = this.stocksRepository.save(stocks);
		return ResponseEntity.ok(save);
	}
	
	//Posting multiple Stocks at once
	@PostMapping("/push/trends")
    public ResponseEntity<List<Stocks>> addStocks(@RequestBody List<Stocks> stocks) {
        List<Stocks> savedStocks = stocksRepository.saveAll(stocks);
        return ResponseEntity.ok(savedStocks);
    }
	
	//Updating one Stock
	@PutMapping("/{id}")
    public ResponseEntity<Stocks> updateStock(@PathVariable String id, @RequestBody Stocks stock) {
        Optional<Stocks> optionalStock = stocksRepository.findById(id);
        if (optionalStock.isPresent()) {
        	Stocks existingStock = optionalStock.get();
        	existingStock.setName(stock.getName());
        	existingStock.setStars(stock.getStars());
            Stocks updatedDocument = stocksRepository.save(existingStock);
            return ResponseEntity.ok(updatedDocument);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	//Deleting one Stock
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable String id) {
        stocksRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
