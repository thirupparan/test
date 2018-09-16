package com.sgic.myleave.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface LeaveRepository extends JpaRepository<Leave, Long>,QuerydslPredicateExecutor<Leave> {

}
