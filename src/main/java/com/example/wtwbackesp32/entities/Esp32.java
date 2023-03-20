package com.example.wtwbackesp32.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "esp32")
public class Esp32 {
    @Id
    private String id;

    private String key;
    private String type;
}
