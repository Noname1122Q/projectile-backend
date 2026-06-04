package com.example.demo.dto;

import java.util.List;

public class OutputDTO {

    public List<TrajectoryPoint> trajectory;

    public double maxHeight;
    public double range;
    public double flightTime;
    public double impactVelocity;

    public OutputDTO(
            List<TrajectoryPoint> trajectory,
            double maxHeight,
            double range,
            double flightTime,
            double impactVelocity
    ) {
        this.trajectory = trajectory;
        this.maxHeight = maxHeight;
        this.range = range;
        this.flightTime = flightTime;
        this.impactVelocity = impactVelocity;
    }
}