package com.sgic.myleave.entity;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Long>,QuerydslPredicateExecutor<User>{
	User findByName(String name);
	List<User> findAllByName(String name);

}
