package com.ericsson.front.end.controllers;

import com.ericsson.front.end.model.Retrospective;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("${retrospective.controller.base.endpoint}")
public class RetrospectiveController {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${server.port}")
    private String frontEndServerPort;

    @Value("${backend.base.endpoint}")
    private String baseBackendEndpoint;

    @Value("${retrospective.controller.base.endpoint}")
    private String retrospectiveControllerBaseEndpoint;

    @Value("${controller.save.endpoint}")
    private String saveEndpoint;

    @Value("${controller.find.all.endpoint}")
    private String findAllEndpoint;

    @Value("${save.retrospective.template}")
    private String saveRetrospectiveTemplatePage;

    @Value("${board.controller.base.endpoint}")
    private String boardControllerBaseEndpoint;

    @Value("${retrospective.controller.find.by.id.endpoint}")
    private String findByIdEndpoint;

    @Value("${find.retrospective.template}")
    private String findByIdTemplate;

    @GetMapping(value = "${controller.save.endpoint}")
    public String getSaveRetrospectivePage(Retrospective retrospective) {
        return saveRetrospectiveTemplatePage;
    }

    @PostMapping(value = "${controller.save.endpoint}", consumes={"application/json","application/xml"})
    public String saveRetrospective(@RequestBody Retrospective retro) {
        restTemplate.postForEntity(
                baseBackendEndpoint + retrospectiveControllerBaseEndpoint + saveEndpoint,
                retro,
                Retrospective.class
        );

        return "redirect:" + boardControllerBaseEndpoint;
    }

    @GetMapping(value = "${retrospective.controller.find.by.id.endpoint}{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        String url = baseBackendEndpoint + retrospectiveControllerBaseEndpoint + findByIdEndpoint + id;

        System.out.println(url);

        ResponseEntity<Retrospective> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Retrospective>(){}
        );

        Retrospective retrospective = responseEntity.getBody();
        model.addAttribute("retro", retrospective);

        return findByIdTemplate;
    }
}
