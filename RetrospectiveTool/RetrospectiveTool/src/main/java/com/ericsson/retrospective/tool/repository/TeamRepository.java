package com.ericsson.retrospective.tool.repository;

import com.ericsson.retrospective.tool.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
