package com.example.projectile.dto;

import java.util.List;

public class OutputDTO {
    public List<Double> x;
    public List<Double> y;

    public OutputDTO(List<Double> x, List<Double> y) {
        this.x = x;
        this.y = y;
    }
}
