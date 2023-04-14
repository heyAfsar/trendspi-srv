package com.crashtech.trendspisrv.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	
	//Getting single Stock 
    @GetMapping("/get/{id}")
    public ResponseEntity<Stocks> getStock(@PathVariable String id) {
        Optional<Stocks> optionalDocument = stocksRepository.findById(id);
        if (optionalDocument.isPresent()) {
        	Stocks document = optionalDocument.get();
            return ResponseEntity.ok(document);
        } else {
            return ResponseEntity.notFound().build();
        }
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
	
	//Deleting multiple stocks
	@DeleteMapping("/delete/trends")
    public ResponseEntity<Void> deleteStocks(@RequestBody List<String> ids) {
        stocksRepository.deleteAllByIdIn(ids);
        return ResponseEntity.noContent().build();
    }

	//How to Call or Consume External API in Spring Boot
	@GetMapping("/get/empmicroservicedata")
	public ResponseEntity<?> empmicroservicedata() {
	    try {
	        String uri="https://dummy.restapiexample.com/api/v1/employees";
	        RestTemplate restTemplate = new RestTemplate();
	        String result = restTemplate.getForObject(uri, String.class);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }catch (Exception e){
	        e.printStackTrace();
	        return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
	
}
