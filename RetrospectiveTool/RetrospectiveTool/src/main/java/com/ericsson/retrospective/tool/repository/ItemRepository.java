package com.ericsson.retrospective.tool.repository;

import com.ericsson.retrospective.tool.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
