package com.example.wtwbackesp32.services;

import com.example.wtwbackesp32.controllers.dtos.requests.CreateEsp32Request;
import com.example.wtwbackesp32.controllers.dtos.responses.BaseResponse;
import com.example.wtwbackesp32.controllers.dtos.responses.CreateEsp32Response;
import com.example.wtwbackesp32.entities.Esp32;
import com.example.wtwbackesp32.repositories.IEsp32Repository;
import com.example.wtwbackesp32.services.interfaces.IEsp32Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class Esp32ServiceImpl implements IEsp32Service {
    @Autowired
    private IEsp32Repository repository;

    @Override
    public BaseResponse create(CreateEsp32Request request) {
        Esp32 esp32 = from(request);

        return BaseResponse.builder()
                .data(from(repository.save(esp32)))
                .message("Esp32 created correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public BaseResponse update(String id, CreateEsp32Request request) {
        Esp32 esp32 = findAndEnsureExist(id);

        esp32.setKey(request.getKey());
        esp32.setType(request.getType());
        return BaseResponse.builder()
                .data(from(repository.save(esp32)))
                .message("Esp32 updated correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    private Esp32 from(CreateEsp32Request request) {
        Esp32 esp32 = new Esp32();

        esp32.setKey(request.getKey());
        esp32.setType(request.getType());
        return esp32;
    }

    private CreateEsp32Response from(Esp32 esp32){
        CreateEsp32Response response = new CreateEsp32Response();

        response.setKey(esp32.getKey());
        response.setType(esp32.getType());
        return response;
    }

    private Esp32 findAndEnsureExist(String id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
