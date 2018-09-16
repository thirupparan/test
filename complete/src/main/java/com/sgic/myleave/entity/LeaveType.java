package com.sgic.myleave.entity;


public class LeaveType {
Integer id;
String type;
Integer allocatedDays;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Integer getAllocatedDays() {
	return allocatedDays;
}
public void setAllocatedDays(Integer allocatedDays) {
	this.allocatedDays = allocatedDays;
}
public LeaveType(Integer id, String type, Integer allocatedDays) {
	super();
	this.id = id;
	this.type = type;
	this.allocatedDays = allocatedDays;
}
}
