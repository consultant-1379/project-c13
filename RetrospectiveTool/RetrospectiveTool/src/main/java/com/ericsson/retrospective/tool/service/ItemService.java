package com.ericsson.retrospective.tool.service;

import com.ericsson.retrospective.tool.dtos.ItemDto;

import java.util.List;

public interface ItemService {

    ItemDto save(ItemDto itemDto) throws IllegalArgumentException;

    List<ItemDto> findAll();

    ItemDto getById(int id);
}
