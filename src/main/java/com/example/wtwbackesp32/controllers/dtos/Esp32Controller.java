package com.example.wtwbackesp32.controllers.dtos;

import com.example.wtwbackesp32.controllers.dtos.requests.CreateEsp32Request;
import com.example.wtwbackesp32.controllers.dtos.responses.BaseResponse;
import com.example.wtwbackesp32.services.interfaces.IEsp32Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("esp32")
public class Esp32Controller {
    @Autowired
    private IEsp32Service service;

    @PostMapping()
    public BaseResponse create(@RequestBody CreateEsp32Request request) {
        return service.create(request);
    }

    @PutMapping("{id}")
    public BaseResponse update(@PathVariable String id, @RequestBody CreateEsp32Request request){
        return service.update(id, request);
    }
}
