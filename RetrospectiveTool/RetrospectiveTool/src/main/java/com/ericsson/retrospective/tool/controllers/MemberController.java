package com.ericsson.retrospective.tool.controllers;

import com.ericsson.retrospective.tool.dtos.MemberDto;
import com.ericsson.retrospective.tool.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("${member.controller.base.endpoint}")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(value = "${member.controller.save.endpoint}",
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity<MemberDto> saveMember(@RequestBody MemberDto memberDto) {
        try {
            MemberDto savedMember = memberService.save(memberDto);
            return ResponseEntity.ok().body(savedMember);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(value = "${member.controller.find.all.endpoint}",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<List<MemberDto>> findAll() {
        List<MemberDto> memberList = memberService.findAll();
        return  ResponseEntity.ok().body(memberList);
    }

    @GetMapping(value = "${member.controller.find.by.id.endpoint}{id}")
    public ResponseEntity<MemberDto> findById(@PathVariable("id") int id) {
        try {
            MemberDto member = memberService.getById(id);
            return ResponseEntity.ok().body(member);
        } catch (NullPointerException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}