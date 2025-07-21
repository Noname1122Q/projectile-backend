package com.example.projectile.controller;

import com.example.projectile.dto.InputDTO;
import com.example.projectile.dto.OutputDTO;
import com.example.projectile.service.ProjectileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // Allows requests from frontend
@RestController
@RequestMapping("/api/simulation")
public class SimulationController {

    @Autowired
    private ProjectileService projectileService;

    @PostMapping
    public OutputDTO simulate(@RequestBody InputDTO input) {
        return projectileService.simulate(input);
    }
}
