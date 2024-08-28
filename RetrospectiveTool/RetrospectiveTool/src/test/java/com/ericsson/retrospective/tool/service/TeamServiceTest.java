package com.ericsson.retrospective.tool.service;

import com.ericsson.retrospective.tool.dtos.TeamDto;
import com.ericsson.retrospective.tool.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class TeamServiceTest {
    @Mock
    private TeamRepository teamRepository;

    @Autowired
    private TeamService teamService;

    @Test()
    void invalid_name_addTeam() {
        TeamDto team = new TeamDto("");

        try {

            teamService.save(team);
            fail();
        } catch (IllegalArgumentException ex) {
            assertEquals("Name cannot be null.", ex.getMessage());
        }
    }

    @Test()
    void valid_name_addTeam() {
        TeamDto team = new TeamDto("Name");
        TeamDto teamDto = teamService.save(team);

        assertEquals(team.getName(), teamDto.getName());
    }

    @Test
    void empty_findAllTeams() {
        assertThat(teamRepository.findAll().isEmpty()).isTrue();
    }

    @Test
    void populated_findAllTeams() {
        TeamDto team = new TeamDto("Name");
        TeamDto t = teamService.save(team);

        List<TeamDto> teams = new ArrayList<>();
        teams.add(t);

        assertEquals(teamService.findAll().size(), teams.size());
    }
}
