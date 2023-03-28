package com.crashtech.trendspisrv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crashtech.trendspisrv.modal.Stocks;

public interface StocksRepository extends MongoRepository<Stocks, String> {

}
