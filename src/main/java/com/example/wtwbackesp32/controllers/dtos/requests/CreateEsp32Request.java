package com.example.wtwbackesp32.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateEsp32Request {
    private String key;
    private String type;
}
