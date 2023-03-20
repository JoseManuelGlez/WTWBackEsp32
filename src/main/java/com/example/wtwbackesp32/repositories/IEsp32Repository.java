package com.example.wtwbackesp32.repositories;

import com.example.wtwbackesp32.entities.Esp32;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEsp32Repository extends MongoRepository<Esp32, String> {

}
