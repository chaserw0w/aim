package com.chaserw0w.aim.repository;

import com.chaserw0w.aim.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
