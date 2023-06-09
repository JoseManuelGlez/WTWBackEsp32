package com.example.wtwbackesp32.repositories;

import com.example.wtwbackesp32.controllers.dtos.responses.CreateEsp32Response;
import com.example.wtwbackesp32.entities.Esp32;
import com.example.wtwbackesp32.entities.projections.IEsp32Projection;
import com.example.wtwbackesp32.entities.projections.IEsp32UserProjection;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEsp32Repository extends JpaRepository<Esp32, Long> {
    @Query(value = "SELECT esp32.id AS espId, esp32.type AS espType, esp32.key_esp32 AS espKey  FROM esp32 " +
            "WHERE esp32.user_id = :userId ;", nativeQuery = true)
    List <IEsp32Projection> findByUserId(Long userId);

    @Query(value = "SELECT esp32.user_id AS userId FROM esp32 WHERE esp32.key_esp32 = :Key ;", nativeQuery = true)
    IEsp32UserProjection findUserByKey(String Key);
}
