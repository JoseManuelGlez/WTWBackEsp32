package com.example.wtwbackesp32.services;

import com.example.wtwbackesp32.controllers.dtos.requests.CreateEsp32Request;
import com.example.wtwbackesp32.controllers.dtos.responses.BaseResponse;
import com.example.wtwbackesp32.controllers.dtos.responses.CreateEsp32Response;
import com.example.wtwbackesp32.entities.Esp32;
import com.example.wtwbackesp32.entities.projections.IEsp32Projection;
import com.example.wtwbackesp32.entities.projections.IEsp32UserProjection;
import com.example.wtwbackesp32.repositories.IEsp32Repository;
import com.example.wtwbackesp32.services.interfaces.IEsp32Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public BaseResponse update(Long id, CreateEsp32Request request) {
        Esp32 esp32 = findAndEnsureExist(id);

        esp32.setKeyEsp32(request.getKeyEsp32());
        esp32.setType(request.getType());
        esp32.setUserId(request.getUserId());
        return BaseResponse.builder()
                .data(from(repository.save(esp32)))
                .message("Esp32 updated correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public BaseResponse findByUserId(Long userId){
        List<IEsp32Projection> iEsp32Projections = from(userId);
        return BaseResponse.builder()
                .data(iEsp32Projections)
                .message("BaseResponse created")
                .success(Boolean.TRUE)
                    .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public BaseResponse findUserByKey(String key) {
        return from(repository.findUserByKey(key));
    }

    private BaseResponse from(IEsp32UserProjection projection) {
        return BaseResponse.builder()
                .data(projection)
                .message("User found")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    private List<IEsp32Projection> from(Long userId){
        return repository.findByUserId(userId);
    }

    /*private CreateEsp32Response from(IEsp32Projection projection) {
        CreateEsp32Response response = new CreateEsp32Response();
        response.setUserId(projection.getEspUserId());
        response.setId(projection.getEspId());
        response.setKeyEsp32(projection.getEspKeyEsp32());
        response.setType(projection.getEspType());
        return response;
    }*/

    private Esp32 from(CreateEsp32Request request) {
        Esp32 esp32 = new Esp32();

        esp32.setKeyEsp32(request.getKeyEsp32());
        esp32.setType(request.getType());
        esp32.setUserId(request.getUserId());
        return esp32;
    }

    private CreateEsp32Response from(Esp32 esp32){
        CreateEsp32Response response = new CreateEsp32Response();

        response.setId(esp32.getId());
        response.setKeyEsp32(esp32.getKeyEsp32());
        response.setType(esp32.getType());
        response.setUserId(esp32.getUserId());
        return response;
    }

    private Esp32 findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
