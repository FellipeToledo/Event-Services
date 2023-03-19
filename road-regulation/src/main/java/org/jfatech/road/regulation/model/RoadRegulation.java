package org.jfatech.road.regulation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jfatech.model.AbstractEntity;
import org.jfatech.road.regulation.enums.RoadRegulationType;

import java.time.LocalDateTime;

/**
 * @author Fellipe Toledo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoadRegulation implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "The field 'ordinance' is mandatory")
    @Column(nullable = false)
    private String ordinance;

    @NotNull(message = "The field 'ordinanceNumber' is mandatory")
    @Column(nullable = false)
    private int ordinanceNumber;

    @Column(nullable = false)
    @Enumerated
    private RoadRegulationType roadRegulationType;

    @NotNull(message = "The field 'neighborhood' is mandatory")
    @Column(nullable = false)
    private String neighborhood;

    @NotNull(message = "The field 'description' is mandatory")
    @Column(nullable = false)
    private String description;

    @NotNull(message = "The field 'startDateTime' is mandatory")
    @Column(nullable = false)
    private LocalDateTime startDateTime;

    @NotNull(message = "The field 'endDateTime' is mandatory")
    @Column(nullable = false)
    private LocalDateTime endDateTime;

    @NotNull(message = "The field 'interdictionPlace' is mandatory")
    @Column(nullable = false)
    private String interdictionPlace;

    @NotNull(message = "The field 'bypassRoute' is mandatory")
    @Column(nullable = false)
    private String bypassRoute;

    @Override
    public Long getId() {
        return id;
    }
}
