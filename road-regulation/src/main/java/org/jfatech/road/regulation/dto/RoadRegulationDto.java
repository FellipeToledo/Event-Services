package org.jfatech.road.regulation.dto;

import lombok.*;
import org.jfatech.road.regulation.enums.RoadRegulationType;

import java.time.LocalDateTime;

/**
 * @author Fellipe Toledo
 */


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoadRegulationDto {
    private Long id;
    private String ordinance;
    private int ordinanceNumber;
    private RoadRegulationType roadRegulationType;
    private String neighborhood;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String interdictionPlace;
    private String bypassRoute;
}
