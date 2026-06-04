package com.example.demo.controller;


import com.example.demo.dto.OutputDTO;
import com.example.demo.service.ProjectileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // Allows requests from frontend
@RestController
@RequestMapping("/api/simulation")
public class SimulationController {

    @Autowired
    private ProjectileService projectileService;

    @PostMapping
    public OutputDTO simulate(@RequestBody com.example.demo.dto.InputDTO input) {
        return projectileService.simulate(input);
    }
}