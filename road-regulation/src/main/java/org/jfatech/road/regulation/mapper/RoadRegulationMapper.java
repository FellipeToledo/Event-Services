package org.jfatech.road.regulation.mapper;

import org.jfatech.road.regulation.dto.RoadRegulationDto;
import org.jfatech.road.regulation.model.RoadRegulation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fellipe Toledo
 */

@Component
@RequiredArgsConstructor
public class RoadRegulationMapper {
    private final ModelMapper modelMapper;

    public RoadRegulationDto roadRegulationToRoadRegulationDto(RoadRegulation roadRegulation) {
        return modelMapper.map(roadRegulation, RoadRegulationDto.class);
    }

    public RoadRegulation roadRegulationDtoToRoadRegulation(RoadRegulationDto roadRegulationDto) {
        return modelMapper.map(roadRegulationDto, RoadRegulation.class);
    }

    public List<RoadRegulationDto> toRoadRegulationDtosList(List<RoadRegulation> roadRegulations) {
        return roadRegulations.stream().map(this::roadRegulationToRoadRegulationDto)
                .collect(Collectors.toList());
    }
}
