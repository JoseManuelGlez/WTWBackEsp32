package com.example.wtwbackesp32.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateEsp32Response {
    private Long id;
    private String key;
    private String type;
}
