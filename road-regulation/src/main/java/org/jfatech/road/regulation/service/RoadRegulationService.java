package org.jfatech.road.regulation.service;

import org.jfatech.road.regulation.dto.RoadRegulationDto;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
public interface RoadRegulationService {

    RoadRegulationDto createRoadRegulation(RoadRegulationDto roadRegulation);

    RoadRegulationDto updateRoadRegulation(RoadRegulationDto roadRegulation, Long roadRegulationId);

    RoadRegulationDto getRoadRegulationById(Long roadRegulationId);

    List<RoadRegulationDto> getAllRoadRegulations();

    void deleteRoadRegulation(Long roadRegulationId);

}
