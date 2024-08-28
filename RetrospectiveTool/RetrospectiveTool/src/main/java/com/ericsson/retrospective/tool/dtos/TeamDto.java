package com.ericsson.retrospective.tool.dtos;

import com.ericsson.retrospective.tool.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamDto {

    private int id;
    private List<Integer> teamMembers;
    private String name;

    public TeamDto(String name) {
        this.name = name;
    }

    public TeamDto() {
        this.name = "";
        this.teamMembers = new ArrayList<>();
    }

    public TeamDto(Team team) {
        this.id = team.getId();
        this.teamMembers = team.getTeamMembers();
        this.name = team.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Integer> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
