package com.ericsson.front.end.controllers;

import com.ericsson.front.end.model.Team;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
@RequestMapping("${team.controller.base.endpoint}")
public class TeamController {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${server.port}")
    private String frontEndServerPort;

    @Value("${backend.base.endpoint}")
    private String baseBackendEndpoint;

    @Value("${team.controller.base.endpoint}")
    private String teamControllerBaseEndpoint;

    @Value("${controller.save.endpoint}")
    private String saveEndpoint;

    @Value("${controller.find.all.endpoint}")
    private String findAllEndpoint;

    @Value("${save.team.template}")
    private String saveTeamTemplatePage;

    @Value("${board.controller.base.endpoint}")
    private String boardControllerBaseEndpoint;

    @GetMapping(value = "${controller.save.endpoint}")
    public String getSaveTeamPage(Team team) {
        return saveTeamTemplatePage;
    }

    @PostMapping(value = "${controller.save.endpoint}", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String saveTeam(@Valid Team team, BindingResult result, Model model) {
        restTemplate.postForEntity(
                baseBackendEndpoint + teamControllerBaseEndpoint + saveEndpoint,
                team,
                Team.class
        );

        return "redirect:" + boardControllerBaseEndpoint;
    }
}
