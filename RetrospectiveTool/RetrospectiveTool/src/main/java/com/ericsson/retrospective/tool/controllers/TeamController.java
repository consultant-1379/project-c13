package com.ericsson.retrospective.tool.controllers;

import com.ericsson.retrospective.tool.dtos.TeamDto;
import com.ericsson.retrospective.tool.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${team.controller.base.endpoint}")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping(value = "${controller.save.endpoint}",
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity<TeamDto> saveTeam(@RequestBody TeamDto teamDto) {
        try {
            TeamDto createdTeam = teamService.save(teamDto);
            return ResponseEntity.ok().body(createdTeam);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "${controller.find.all.endpoint}",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<List<TeamDto>> findAll() {
        List<TeamDto> teamList = teamService.findAll();
        return ResponseEntity.ok().body(teamList);
    }

    @GetMapping(value = "${team.controller.find.by.id.endpoint}{id}")
    public ResponseEntity<TeamDto> findById(@PathVariable("id") int id) {
        try {
            TeamDto team = teamService.getById(id);
            return ResponseEntity.ok().body(team);
        } catch (NullPointerException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
