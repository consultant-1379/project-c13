package com.ericsson.retrospective.tool.controllers;

import com.ericsson.retrospective.tool.dtos.ItemDto;
import com.ericsson.retrospective.tool.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${item.controller.base.endpoint}")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(value = "${item.controller.save.endpoint}",
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity<ItemDto> saveItem(@RequestBody ItemDto itemDto) {
        try {
            ItemDto savedItem = itemService.save(itemDto);
            return ResponseEntity.ok().body(savedItem);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "${item.controller.find.all.endpoint}",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<List<ItemDto>> findAll() {
        List<ItemDto> itemList = itemService.findAll();
        return ResponseEntity.ok().body(itemList);
    }

    @GetMapping(value = "${item.controller.find.by.id.endpoint}{id}")
    public ResponseEntity<ItemDto> findById(@PathVariable("id") int id) {
        try {
            ItemDto item = itemService.getById(id);
            return ResponseEntity.ok().body(item);
        } catch (NullPointerException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}