package com.ericsson.retrospective.tool.model;

import com.ericsson.retrospective.tool.dtos.TeamDto;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection(targetClass = Integer.class)
    private List<Integer> teamMembers;

    private String name;

    public Team(TeamDto teamDto) {
        this.teamMembers = teamDto.getTeamMembers();
        this.name = teamDto.getName();
    }

    public Team() {
        this.name = "";
        this.teamMembers = new ArrayList<>();
    }

    public Team(String name) {
        this.teamMembers = new ArrayList<>();
        this.name = name;
    }

    public List<Integer> getTeamMembers() {
        return teamMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
