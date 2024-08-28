package com.ericsson.retrospective.tool.service;

import com.ericsson.retrospective.tool.dtos.MemberDto;
import com.ericsson.retrospective.tool.model.Member;
import com.ericsson.retrospective.tool.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {
    Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberRepository memberRepository;

    /*
     * Creating a new member. This is invalid if there is no name.
     * @param Member object to be saved to the persisted.
     * @return Newly created Member object.
     */

    @Override
    public MemberDto save(MemberDto memberDto) throws IllegalArgumentException {
        if (memberDto.getName().isEmpty()) {
            logger.error("Name cannot be empty.");
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            logger.info("Valid data to save a member.");
            Member savedMember = memberRepository.save(new Member(memberDto));
            logger.info("Successfully saved a new member.");
            return new MemberDto(savedMember);
        }
    }

    @Override
    public List<MemberDto> findAll() {
        List<Member> members = memberRepository.findAll();

        return members.stream()
                .map(MemberDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public MemberDto getById(int id) {
        if (memberRepository.existsById(id)) {
            Member m = memberRepository.getById(id);
            return new MemberDto(m);
        } else {
            throw new NullPointerException();
        }
    }
}