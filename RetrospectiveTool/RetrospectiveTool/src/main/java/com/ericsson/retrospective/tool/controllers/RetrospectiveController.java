package com.ericsson.retrospective.tool.controllers;

import com.ericsson.retrospective.tool.dtos.RetrospectiveDto;
import com.ericsson.retrospective.tool.service.RetrospectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("${retrospective.controller.base.endpoint}")
public class RetrospectiveController {
    @Autowired
    private RetrospectiveService retrospectiveService;

    @PostMapping(value = "${retrospective.controller.save.endpoint}",
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity<RetrospectiveDto> saveRetrospective(@RequestBody RetrospectiveDto retrospectiveDto) {
        try {
            RetrospectiveDto savedRetrospective = retrospectiveService.save(retrospectiveDto);
            return ResponseEntity.ok().body(savedRetrospective);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "${retrospective.controller.find.all.endpoint}",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<List<RetrospectiveDto>> findAll() {
        List<RetrospectiveDto> retrospectiveList = retrospectiveService.findAll();
        return ResponseEntity.ok().body(retrospectiveList);
    }

    @GetMapping(value = "${retrospective.controller.find.by.id.endpoint}{id}")
    public ResponseEntity<RetrospectiveDto> findById(@PathVariable("id") int id) {
        try {
            RetrospectiveDto retrospective = retrospectiveService.getById(id);
            return ResponseEntity.ok().body(retrospective);
        } catch (NullPointerException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
