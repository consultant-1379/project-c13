package com.ericsson.retrospective.tool.repository;

import com.ericsson.retrospective.tool.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
