package com.ericsson.retrospective.tool.service;

import com.ericsson.retrospective.tool.dtos.TeamDto;

import java.util.List;

public interface TeamService {
    TeamDto save(TeamDto team) throws IllegalArgumentException;

    List<TeamDto> findAll();

    TeamDto getById(int id);
}
