package com.gul.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gul.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findAllByProjectIdAndManagerId(long projectId, long managerId);

	Task findByIdAndProjectIdAndManagerId(long id, long projectId, long managerId);
}
