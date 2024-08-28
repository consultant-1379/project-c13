package com.ericsson.retrospective.tool.model;

import com.ericsson.retrospective.tool.dtos.ItemDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Category category;
    private int votes;

    public Item(String name) {
        this.name = name;
        this.votes = 0;
    }

    public Item(ItemDto itemDto){
        this.name = itemDto.getName();
        this.category = itemDto.getCategory();
        this.votes = itemDto.getVotes();
    }

    public Item() {
        this("");
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

    public Category getCategory() {
        return category;
    }

    public int getVotes() {
        return votes;
    }
}
