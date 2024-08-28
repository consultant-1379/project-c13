package com.ericsson.front.end.model;

import java.io.Serializable;
import java.util.List;

public class Retrospective implements Serializable {

    private int id;
    private boolean isComplete;
    private List<Integer> items;
    private Team team;
    private String name;

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

    @Override
    public String toString() {
        return "Retrospective{" +
                "id=" + id +
                ", isComplete" + isComplete +
                ", items=" + items +
                ", team=" + team.toString() +
                ", name='" + name + '\'' +
                '}';
    }
}
