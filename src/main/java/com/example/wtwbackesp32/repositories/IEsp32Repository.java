package com.example.wtwbackesp32.repositories;

import com.example.wtwbackesp32.entities.Esp32;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEsp32Repository extends JpaRepository <Esp32, Long> {

}
