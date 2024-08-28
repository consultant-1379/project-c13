package com.ericsson.retrospective.tool.dtos;

import com.ericsson.retrospective.tool.model.Retrospective;
import com.ericsson.retrospective.tool.model.Team;

import java.util.ArrayList;
import java.util.List;

public class RetrospectiveDto {
    private int id;

    private boolean isComplete;

    private List<Integer> items;

    private Team team;

    private String name;

    public RetrospectiveDto(Retrospective retrospective) {
        this.id = retrospective.getId();
        this.isComplete = retrospective.isComplete();
        this.items = retrospective.getItems();
        this.team = retrospective.getTeam();
        this.name = retrospective.getName();
    }

    public RetrospectiveDto() {
        this.name = "";
        this.items = new ArrayList<>();
    }

    public RetrospectiveDto(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
