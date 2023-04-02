package com.crashtech.trendspisrv.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crashtech.trendspisrv.modal.Stocks;

public interface StocksRepository extends MongoRepository<Stocks, String> {
	
	Optional<Stocks> findById(String id);
	
    void deleteById(String id);

}
