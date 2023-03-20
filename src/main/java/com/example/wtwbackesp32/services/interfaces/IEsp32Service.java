package com.example.wtwbackesp32.services.interfaces;

import com.example.wtwbackesp32.controllers.dtos.requests.CreateEsp32Request;
import com.example.wtwbackesp32.controllers.dtos.responses.BaseResponse;
import org.springframework.stereotype.Service;

public interface IEsp32Service {
    BaseResponse create(CreateEsp32Request request);

    BaseResponse update(String id, CreateEsp32Request request);
}
