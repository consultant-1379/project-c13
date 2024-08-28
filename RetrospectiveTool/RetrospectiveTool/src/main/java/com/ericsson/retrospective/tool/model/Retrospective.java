package com.ericsson.retrospective.tool.model;

import com.ericsson.retrospective.tool.dtos.RetrospectiveDto;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "retrospectives")
public class Retrospective {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean isComplete;

    @ElementCollection(targetClass=Integer.class)
    private List<Integer> items;

    @ManyToOne(targetEntity = Team.class)
    private Team team;

    private String name;

    public Retrospective(RetrospectiveDto retrospectiveDto) {
        this.isComplete = retrospectiveDto.isComplete();
        this.items = retrospectiveDto.getItems();
        this.team = retrospectiveDto.getTeam();
        this.name = retrospectiveDto.getName();
    }

    public Retrospective(String name){
        isComplete = false;
        this.items = new ArrayList<>();
        this.name = name;
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

    public void setItem(Integer itemID){this.items.add(itemID);}

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getId(){return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){return name;}

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Retrospective{" +
                "id=" + id +
                ", isComplete=" + isComplete +
                ", items=" + items +
                ", team=" + team +
                ", name='" + name + '\'' +
                '}';
    }
}
