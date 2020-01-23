package com.gul.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gul.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	List<Project> findAllByManagerId(Long managerId);
}
