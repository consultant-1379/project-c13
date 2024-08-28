package com.ericsson.retrospective.tool.service;
import com.ericsson.retrospective.tool.dtos.MemberDto;
import com.ericsson.retrospective.tool.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Test()
    void invalid_name_addMember() {
        MemberDto member = new MemberDto("");

        try {
            memberService.save(member);
            fail();
        } catch (IllegalArgumentException ex) {
            assertEquals("Name cannot be empty.", ex.getMessage());
        }
    }

    @Test()
    void valid_name_addMember() {
        MemberDto member = new MemberDto("Name");
        MemberDto m = memberService.save(member);

        assertEquals(member.getName(), m.getName());
    }

    @Test
    void empty_findAllItems() {
        assertThat(memberRepository.findAll().isEmpty()).isTrue();
    }

    @Test
    void invalid_findMember() {
        MemberDto member = new MemberDto("Test");
        MemberDto result = memberService.save(member);
        int invalidId = result.getId() * 2;

        try {
            memberService.getById(invalidId);
            fail();
        } catch (NullPointerException exception) {
            assertEquals(new NullPointerException().getMessage(), exception.getMessage());
        }
    }
}