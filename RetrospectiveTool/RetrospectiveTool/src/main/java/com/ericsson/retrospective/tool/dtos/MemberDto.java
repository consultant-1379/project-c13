package com.ericsson.retrospective.tool.dtos;
import com.ericsson.retrospective.tool.model.Member;

public class MemberDto {
    private int id;
    private String name;

    public MemberDto() {
        this.name = "";
    }

    public MemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
    }

    public MemberDto(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
