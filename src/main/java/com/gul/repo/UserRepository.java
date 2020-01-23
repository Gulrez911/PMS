package com.gul.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gul.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);

	List<User> findByManagerId(long id);

	List<User> findByUserTypeContaining(String user);

	List<User> findByUserTypeNotContainingIgnoreCaseOrderByUserType(String user);

	Page<User> findByUserTypeNotContainingIgnoreCaseOrderByUserType(String user, Pageable pageable);
}
