package com.sgic.myleave.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long>,QuerydslPredicateExecutor<LeaveRequest> {
	@Query("select lr from LeaveRequest as lr where lr.user.name = ?1 and lr.leave.allocation =?2")
	List<LeaveRequest> findByUserNameAndAllocation(String name, Integer allocation);

}
