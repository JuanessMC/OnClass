package com.pragma.bootcamp2024.adapters.driving.http.controller;

import com.pragma.bootcamp2024.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.pragma.bootcamp2024.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.pragma.bootcamp2024.domain.api.ITechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {
    private final ITechnologyServicePort technologyServicePort;
    private final ITechnologyRequestMapper technologyRequestMapper;

    @PostMapping("/")
    public ResponseEntity<String> addTechnology(@Valid @RequestBody AddTechnologyRequest request) {
        technologyServicePort.saveTechnology(technologyRequestMapper.addRequestToTechnology(request));
        return ResponseEntity.status(HttpStatus.CREATED).body("The technology has been successfully recorded");
    }

}

