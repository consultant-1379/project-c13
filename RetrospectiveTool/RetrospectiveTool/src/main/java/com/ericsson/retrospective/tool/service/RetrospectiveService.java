package com.ericsson.retrospective.tool.service;

import com.ericsson.retrospective.tool.dtos.RetrospectiveDto;

import java.util.List;

public interface RetrospectiveService {
    RetrospectiveDto save(RetrospectiveDto retro) throws IllegalArgumentException;

    List<RetrospectiveDto> findAll();

    RetrospectiveDto getById(int id);
}
