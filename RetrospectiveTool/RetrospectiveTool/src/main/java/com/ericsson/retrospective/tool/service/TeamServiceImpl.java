package com.ericsson.retrospective.tool.service;

import com.ericsson.retrospective.tool.dtos.TeamDto;
import com.ericsson.retrospective.tool.model.Team;
import com.ericsson.retrospective.tool.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    Logger logger = LoggerFactory.getLogger(TeamServiceImpl.class);

    @Autowired
    private TeamRepository teamRepository;

    /**
     * Creating a new team. This is invalid if there is no name.
     *
     * @param team Team object to be saved to the persisted.
     * @return Newly-created Team object.
     */
    @Override
    public TeamDto save(TeamDto teamDto) throws IllegalArgumentException {
        if (teamDto.getName().isEmpty()) {
            logger.error("Name cannot be null.");
            throw new IllegalArgumentException("Name cannot be null.");
        } else {
            logger.info("Valid data to save a team.");
            Team savedTeam = teamRepository.save(new Team(teamDto));
            logger.info("Successfully saved a new team.");
            return new TeamDto(savedTeam);
        }
    }

    @Override
    public List<TeamDto> findAll() {
        List<Team> teams = teamRepository.findAll();

        return teams.stream()
                .map(TeamDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public TeamDto getById(int id) {
        if (teamRepository.existsById(id)) {
            Team t = teamRepository.getById(id);
            return new TeamDto(t);
        } else {
            throw new NullPointerException();
        }
    }
}
