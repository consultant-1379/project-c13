package com.ericsson.front.end.controllers;

import com.ericsson.front.end.model.Retrospective;
import com.ericsson.front.end.model.Team;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("${board.controller.base.endpoint}")
public class BoardController {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${backend.base.endpoint}")
    private String baseBackendEndpoint;

    @Value("${board.controller.base.endpoint}")
    private String boardControllerBaseEndpoint;

    @Value("${team.controller.base.endpoint}")
    private String teamControllerBaseEndpoint;

    @Value("${retrospective.controller.base.endpoint}")
    private String retrospectiveControllerBaseEndpoint;

    @Value("${controller.find.all.endpoint}")
    private String findAllEndpoint;

    @Value("${board.template}")
    private String boardTemplatePage;


    @GetMapping
    public String getAllTeams(Model model) {
        ResponseEntity<List<Team>> responseEntity = restTemplate.exchange(
                baseBackendEndpoint + teamControllerBaseEndpoint + findAllEndpoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Team>>() {}
        );
        ResponseEntity<List<Retrospective>> responseEntity2 = restTemplate.exchange(
                baseBackendEndpoint + retrospectiveControllerBaseEndpoint + findAllEndpoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Retrospective>>() {}
        );

            List<Team> teamList = responseEntity.getBody();
            List<Retrospective> retrospectivesList = responseEntity2.getBody();
            model.addAttribute("teams", teamList);
            model.addAttribute("retrospectives", retrospectivesList);


            return boardTemplatePage;
    }
}
