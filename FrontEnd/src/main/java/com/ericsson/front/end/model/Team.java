package com.ericsson.front.end.model;

import java.io.Serializable;
import java.util.List;

public class Team implements Serializable {
    private int id;
    private List<Integer> teamMemberIds;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getTeamMemberIds() {
        return teamMemberIds;
    }

    public void setTeamMemberIds(List<Integer> teamMemberIds) {
        this.teamMemberIds = teamMemberIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamMemberIds=" + teamMemberIds +
                ", name='" + name + '\'' +
                '}';
    }
}
