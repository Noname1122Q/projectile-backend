package com.example.demo.dto;

public class TrajectoryPoint {

    public double time;
    public double x;
    public double y;
    public double velocityX;
    public double velocityY;

    public TrajectoryPoint(
            double time,
            double x,
            double y,
            double velocityX,
            double velocityY
    ) {
        this.time = time;
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }
}