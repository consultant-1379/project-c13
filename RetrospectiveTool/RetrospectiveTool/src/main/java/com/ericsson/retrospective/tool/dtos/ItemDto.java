package com.ericsson.retrospective.tool.dtos;

import com.ericsson.retrospective.tool.model.Category;
import com.ericsson.retrospective.tool.model.Item;

public class ItemDto {
    private int id;
    private String name;
    private Category category;
    private int votes;

    public ItemDto() {
        this("");
    }

    public ItemDto(Item item){
        this.id = item.getId();
        this.name = item.getName();
        this.category = item.getCategory();
        this.votes = item.getVotes();
    }

    public ItemDto(String name) {
        this.name = name;
        this.votes = 0;
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

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
