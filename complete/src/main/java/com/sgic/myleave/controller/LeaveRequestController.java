package com.sgic.myleave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.myleave.entity.LeaveRequest;
import com.sgic.myleave.service.LeaveRequestService;

@RestController
public class LeaveRequestController {
	@Autowired
	public LeaveRequestService leaveRequestService;

	@PostMapping("/leaveRequest")
	public ResponseEntity<String> addLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
		boolean success = leaveRequestService.addLeaveRequest(leaveRequest);
		String result = "Add leave request failed";
		ResponseEntity<String> status = new ResponseEntity<>(result, HttpStatus.FORBIDDEN);
		if (success) {
			result = "Add leave request succesfully";
			status = new ResponseEntity<>(result, HttpStatus.OK);
		}
		return status;
	}
	@GetMapping("/leaveRequest")
	public List<LeaveRequest> findByUserNameAndAllocation(@RequestParam(value="name")String name,@RequestParam(value="allocation")Integer allocation){
		return leaveRequestService.findByUserNameAndAllocation(name, allocation);
	}
}
