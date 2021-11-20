package com.sparta.projectsub.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<com.sparta.projectsub.domain.Memo, Long> {
    List<com.sparta.projectsub.domain.Memo> findAllByOrderByCreatedAtDesc();
}
