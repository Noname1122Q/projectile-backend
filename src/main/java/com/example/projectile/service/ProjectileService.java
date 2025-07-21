package com.example.projectile.service;

import com.example.projectile.dto.InputDTO;
import com.example.projectile.dto.OutputDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectileService {

    public OutputDTO simulate(InputDTO input) {
        double g = input.g;
        double dragCoeff = input.dragCoeff;
        double initial_velocity = input.initial_velocity;
        double angleDegree = input.angleDegree;
        double deltaT = input.deltaT;

        double angleRadian = Math.toRadians(angleDegree);

        double x = 0.0;
        double y = 0.0;

        double velocityX = initial_velocity * Math.cos(angleRadian);
        double velocityY = initial_velocity * Math.sin(angleRadian);

        List<Double> listX = new ArrayList<>();
        List<Double> listY = new ArrayList<>();

        while (y >= 0) {
            listX.add(x);
            listY.add(y);

            double velocity = Math.sqrt(velocityX * velocityX + velocityY * velocityY);
            double accX = -dragCoeff * velocity * velocityX;
            double accY = -g - dragCoeff * velocity * velocityY;

            velocityX += accX * deltaT;
            velocityY += accY * deltaT;

            x += velocityX * deltaT;
            y += velocityY * deltaT;
        }

        return new OutputDTO(listX, listY);
    }
}
