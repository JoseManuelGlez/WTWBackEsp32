package com.example.wtwbackesp32.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Esp32")
public class Esp32 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyEsp32;
    private String type;
    private Long userId;
}
