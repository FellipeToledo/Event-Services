package org.jfatech.road.regulation.service;

import org.jfatech.exceptions.ResourceNotFoundException;
import org.jfatech.road.regulation.dto.RoadRegulationDto;
import org.jfatech.road.regulation.mapper.RoadRegulationMapper;
import org.jfatech.road.regulation.model.RoadRegulation;
import org.jfatech.road.regulation.repository.RoadRegulationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class RoadRegulationServiceImp implements RoadRegulationService {

    private final RoadRegulationRepository roadRegulationRepository;
    private final RoadRegulationMapper roadRegulationMapper;

    @Override
    public RoadRegulationDto createRoadRegulation(RoadRegulationDto roadRegulationDto) {
        RoadRegulation roadRegulation = roadRegulationMapper.roadRegulationDtoToRoadRegulation(roadRegulationDto);
        RoadRegulation savedRoadRegulation = roadRegulationRepository.save(roadRegulation);
        return roadRegulationMapper.roadRegulationToRoadRegulationDto(savedRoadRegulation);
    }

    @Override
    public RoadRegulationDto updateRoadRegulation(RoadRegulationDto roadRegulationDto, Long roadRegulationId) {
        RoadRegulation roadRegulation = roadRegulationRepository.findById(roadRegulationId)
                .orElseThrow(() -> new ResourceNotFoundException("RoadRegulation", "Id", roadRegulationId));
        roadRegulation.setOrdinance(roadRegulationDto.getOrdinance());
        roadRegulation.setOrdinanceNumber(roadRegulationDto.getOrdinanceNumber());
        roadRegulation.setRoadRegulationType(roadRegulationDto.getRoadRegulationType());
        roadRegulation.setNeighborhood(roadRegulationDto.getNeighborhood());
        roadRegulation.setDescription(roadRegulationDto.getDescription());
        roadRegulation.setStartDateTime(roadRegulationDto.getStartDateTime());
        roadRegulation.setEndDateTime(roadRegulationDto.getEndDateTime());
        roadRegulation.setInterdictionPlace(roadRegulationDto.getInterdictionPlace());
        roadRegulation.setBypassRoute(roadRegulationDto.getBypassRoute());

        RoadRegulation updatedRoadRegulation = roadRegulationRepository.save(roadRegulation);
        return roadRegulationMapper.roadRegulationToRoadRegulationDto(updatedRoadRegulation);
    }

    @Override
    public RoadRegulationDto getRoadRegulationById(Long roadRegulationId) {
        RoadRegulation roadRegulation = roadRegulationRepository.findById(roadRegulationId)
                .orElseThrow(() -> new ResourceNotFoundException("RoadRegulation", "Id", roadRegulationId));
        return roadRegulationMapper.roadRegulationToRoadRegulationDto(roadRegulation);
    }

    @Override
    public List<RoadRegulationDto> getAllRoadRegulations() {
        List<RoadRegulation> roadRegulations = roadRegulationRepository.findAll();
        return roadRegulationMapper.toRoadRegulationDtosList(roadRegulations);
    }

    @Override
    public void deleteRoadRegulation(Long roadRegulationId) {
        RoadRegulation roadRegulation = roadRegulationRepository.findById(roadRegulationId)
                .orElseThrow(() -> new ResourceNotFoundException("RoadRegulation", "Id", roadRegulationId));
        roadRegulationRepository.delete(roadRegulation);
    }
}
