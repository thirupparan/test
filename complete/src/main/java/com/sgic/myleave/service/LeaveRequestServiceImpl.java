package com.sgic.myleave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.myleave.entity.LeaveRequest;
import com.sgic.myleave.entity.LeaveRequestRepository;
@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
	@Autowired
	private LeaveRequestRepository leaveRequestRepo;

	@Override
	public boolean addLeaveRequest(LeaveRequest leaveRequest) {
		leaveRequestRepo.save(leaveRequest);
		return true;
	}

	@Override
	public List<LeaveRequest> findByUserNameAndAllocation(String name, Integer allocation) {
		return leaveRequestRepo.findByUserNameAndAllocation(name, allocation);
	}
}
