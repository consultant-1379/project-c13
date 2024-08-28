package com.ericsson.retrospective.tool.service;

import com.ericsson.retrospective.tool.dtos.RetrospectiveDto;
import com.ericsson.retrospective.tool.model.Retrospective;
import com.ericsson.retrospective.tool.repository.RetrospectiveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetrospectiveServiceImpl implements RetrospectiveService {
    Logger logger = LoggerFactory.getLogger(RetrospectiveServiceImpl.class);

    @Autowired
    private RetrospectiveRepository retrospectiveRepository;

    @Override
    public RetrospectiveDto save(RetrospectiveDto retrospectiveDto) throws IllegalArgumentException {
        if (retrospectiveDto.getName().isEmpty()) {
            logger.error("Name cannot be null.");
            throw new IllegalArgumentException("Name cannot be null.");
        } else {
            logger.info("Valid data to save a Retrospective.");
            Retrospective savedRetro = retrospectiveRepository.save(new Retrospective(retrospectiveDto));
            logger.info("Successfully saved a new Retrospective.");
            return new RetrospectiveDto(savedRetro);
        }
    }

    @Override
    public List<RetrospectiveDto> findAll() {
        List<Retrospective> retrospectives = retrospectiveRepository.findAll();

        return retrospectives.stream()
                .map(RetrospectiveDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public RetrospectiveDto getById(int id) {
        if (retrospectiveRepository.existsById(id)) {
            Retrospective r = retrospectiveRepository.getById(id);
            return new RetrospectiveDto(r);
        } else {
            throw new NullPointerException();
        }
    }
}
