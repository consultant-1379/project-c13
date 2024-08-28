package com.ericsson.retrospective.tool.service;

import com.ericsson.retrospective.tool.dtos.RetrospectiveDto;
import com.ericsson.retrospective.tool.repository.RetrospectiveRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class RetrospectiveServiceTest {
    @Mock
    private RetrospectiveRepository retrospectiveRepository;

    @Autowired
    private RetrospectiveService retrospectiveService;

    @Test
    void verify_if_retrospective_is_created() {
        RetrospectiveDto retro = new RetrospectiveDto("Test");
        RetrospectiveDto result = retrospectiveService.save(retro);

        assertEquals(retro.getName(), result.getName());
    }

    @Test
    void empty_findAllRetrospective() {
        assert retrospectiveRepository.findAll().isEmpty();
        assertThat(retrospectiveRepository.findAll().isEmpty()).isTrue();
    }

    @Test
    void invalid_findRetrospective() {
        RetrospectiveDto retro = new RetrospectiveDto("Test");
        RetrospectiveDto result = retrospectiveService.save(retro);
        int invalidId = result.getId() * 2;

        try {
            retrospectiveService.getById(invalidId);
            fail();
        } catch (NullPointerException exception) {
            assertEquals(new NullPointerException().getMessage(), exception.getMessage());
        }
    }
}
