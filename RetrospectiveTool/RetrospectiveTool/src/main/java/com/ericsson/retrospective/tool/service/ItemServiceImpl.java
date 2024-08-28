package com.ericsson.retrospective.tool.service;

import com.ericsson.retrospective.tool.dtos.ItemDto;
import com.ericsson.retrospective.tool.model.Item;
import com.ericsson.retrospective.tool.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemDto save(ItemDto itemDto) throws IllegalArgumentException {
        if(itemDto.getName().isEmpty()) {
            logger.error("Name cannot be empty.");
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            logger.info("Valid data to save a Item.");
            Item savedItem = itemRepository.save(new Item(itemDto));
            logger.info("Successfully a new Item.");
            return new ItemDto(savedItem);
        }
    }

    @Override
    public List<ItemDto> findAll() {
        List<Item> items = itemRepository.findAll();

        return items.stream()
                .map(ItemDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto getById(int id) {
        if (itemRepository.existsById(id)) {
            Item i = itemRepository.getById(id);
            return new ItemDto(i);
        } else {
            throw new NullPointerException();
        }
    }
}
