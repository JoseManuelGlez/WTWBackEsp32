package com.example.wtwbackesp32.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateEsp32Request {
    private String keyEsp32;
    private String type;
    private Long userId;
}
