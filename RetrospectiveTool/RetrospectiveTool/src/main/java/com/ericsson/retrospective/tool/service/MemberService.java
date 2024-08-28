package com.ericsson.retrospective.tool.service;

import com.ericsson.retrospective.tool.dtos.MemberDto;

import java.util.List;

public interface MemberService {

    MemberDto save(MemberDto member) throws IllegalArgumentException;

    List<MemberDto> findAll();

    MemberDto getById(int id);
}
