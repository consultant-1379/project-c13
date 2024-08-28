package com.ericsson.retrospective.tool.repository;

import com.ericsson.retrospective.tool.model.Retrospective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetrospectiveRepository extends JpaRepository<Retrospective, Integer> {

}
