package com.sgic.myleave.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "leave", name = "leave_request")
public class LeaveRequest implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 4155307026285922724L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "leave_id")
	private Leave leave;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "user_id")
	private User user;
	private Integer status;
	private ZonedDateTime fromTime;
	private ZonedDateTime toTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
@JsonIgnore
	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave lave) {
		this.leave = lave;
	}
@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ZonedDateTime getFromTime() {
		return fromTime;
	}

	public void setFromTime(ZonedDateTime fromTime) {
		this.fromTime = fromTime;
	}

	public ZonedDateTime getToTime() {
		return toTime;
	}

	public void setToTime(ZonedDateTime toTime) {
		this.toTime = toTime;
	}

}
