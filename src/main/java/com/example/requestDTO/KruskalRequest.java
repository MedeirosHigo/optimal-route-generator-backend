package com.example.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KruskalRequest {
    private String x;
    private String y;
    private double distance;
}
