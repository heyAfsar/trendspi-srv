package com.crashtech.trendspisrv.controller;

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
@RequestMapping("/getlatesttrends")
public class MainController {

	@Autowired
	private StocksRepository employeeRepository;

	@PostMapping("/")
	public ResponseEntity<?> addEmployee(@RequestBody Stocks employee) {
		Stocks save = this.employeeRepository.save(employee);
		return ResponseEntity.ok(save);
	}

	@GetMapping("/")
	public ResponseEntity<?> getEmployee() {
		return ResponseEntity.ok(this.employeeRepository.findAll());
	}

}
