package org.jfatech.road.regulation.repository;

import org.jfatech.road.regulation.model.RoadRegulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fellipe Toledo
 */
@Repository
public interface RoadRegulationRepository extends JpaRepository<RoadRegulation, Long> {

}
