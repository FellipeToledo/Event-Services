package org.jfatech.road.regulation.controller;

import jakarta.validation.Valid;
import org.jfatech.response.ApiResponse;
import org.jfatech.road.regulation.dto.RoadRegulationDto;
import org.jfatech.road.regulation.service.RoadRegulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
@RestController
@RequestMapping("api/v1/roadRegulation")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoadRegulationController {

    private final RoadRegulationService roadRegulationService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RoadRegulationDto> createRoadRegulation(@Valid @RequestBody RoadRegulationDto roadRegulationDto) {
        RoadRegulationDto createRoadRegulationDto = roadRegulationService.createRoadRegulation(roadRegulationDto);
        return new ResponseEntity<>(createRoadRegulationDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoadRegulationDto> updateRoadRegulation(@Valid @RequestBody RoadRegulationDto roadRegulationDto, @PathVariable("id") long id) {
        RoadRegulationDto updatedRoadRegulation = this.roadRegulationService.updateRoadRegulation(roadRegulationDto, id);
        return ResponseEntity.ok(updatedRoadRegulation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteRoadRegulation(@PathVariable("id") long id) {
        this.roadRegulationService.deleteRoadRegulation(id);
        return new ResponseEntity<>(new ApiResponse("Road Regulation deleted Successfully", true), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<RoadRegulationDto>> getAllRoadRegulation() {
        return ResponseEntity.ok(this.roadRegulationService.getAllRoadRegulations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoadRegulationDto> getRoadRegulationById(@PathVariable long id) {
        return ResponseEntity.ok(this.roadRegulationService.getRoadRegulationById(id));
    }
}