package com.example.demo.service;

import com.example.demo.dto.InputDTO;
import com.example.demo.dto.OutputDTO;
import org.springframework.stereotype.Service;
import com.example.demo.dto.TrajectoryPoint;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectileService {

    public OutputDTO simulate(InputDTO input) {

        double g = input.g;
        double dragCoeff = input.dragCoeff;
        double initialVelocity = input.initial_velocity;
        double angleDegree = input.angleDegree;
        double deltaT = input.deltaT;

        double angleRadian = Math.toRadians(angleDegree);

        double x = 0.0;
        double y = 0.0;
        double time = 0.0;

        double velocityX = initialVelocity * Math.cos(angleRadian);

        double velocityY = initialVelocity * Math.sin(angleRadian);

        List<TrajectoryPoint> trajectory = new ArrayList<>();

        double maxHeight = 0.0;

        double previousX = x;
        double previousY = y;
        double previousTime = time;

        double previousVelocityX = velocityX;
        double previousVelocityY = velocityY;

        while (y >= 0) {

            trajectory.add(
                new TrajectoryPoint(time, x, y, velocityX, velocityY)
            );

            maxHeight = Math.max(maxHeight, y);

            previousX = x;
            previousY = y;
            previousTime = time;

            previousVelocityX = velocityX;
            previousVelocityY = velocityY;

            double speed = Math.sqrt(velocityX * velocityX + velocityY * velocityY);

            double accelerationX = -dragCoeff * speed * velocityX;

            double accelerationY = -g - dragCoeff * speed * velocityY;

            velocityX += accelerationX * deltaT;
            velocityY += accelerationY * deltaT;

            x += velocityX * deltaT;
            y += velocityY * deltaT;

            time += deltaT;
        }


        double ratio = previousY / (previousY - y);

        double landingX = previousX + ratio * (x - previousX);

        double landingTime = previousTime + ratio * (time - previousTime);

        double landingVelocityX = previousVelocityX + ratio * (velocityX - previousVelocityX);

        double landingVelocityY = previousVelocityY + ratio * (velocityY - previousVelocityY);

        trajectory.add(
            new TrajectoryPoint(
                landingTime,
                landingX,
                0.0,
                landingVelocityX,
                landingVelocityY
            )
        );

        double impactVelocity = Math.sqrt(landingVelocityX * landingVelocityX + landingVelocityY * landingVelocityY);

        return new OutputDTO(
            trajectory,
            maxHeight,
            landingX,
            landingTime,
            impactVelocity
        );
    }
}