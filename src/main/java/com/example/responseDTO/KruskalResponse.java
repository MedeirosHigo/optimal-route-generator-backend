package com.example.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class KruskalResponse {
    private String x;
    private String y;
    private double distance;
}
