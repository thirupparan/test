package com.sgic.myleave.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.sgic.myleave.criteria.UserCriteria;
import com.sgic.myleave.entity.QUser;
import com.sgic.myleave.entity.User;
import com.sgic.myleave.entity.UserRepository;

@Service
public class userServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRrpository;

	@Override
	public boolean updateUser(User user) {
//		for (User existingUser : users) {
//			if (existingUser.getId() == user.getId()) {
//				existingUser.setName(user.getName());
//				existingUser.setTelephone(user.getTelephone());
//			}
//			break;
//		}
		return true;
	}

	@Override
	public boolean deleteUser(int id) {
		return false;
	}

	@Override
	public boolean saveUser(User user) {
		userRrpository.save(user);
		return true;
	}

	@Override
	public List<User> viewUser() {
		
		return userRrpository.findAll();
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userRrpository.findByName(name);
	}

	@Override
	public List<User> findAllByName(String name) {
		// TODO Auto-generated method stub
		return userRrpository.findAllByName(name);
	}

	@Override
	public List<User> search(UserCriteria userCriteria) {
		
		List<User> users = new ArrayList<>();
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(userCriteria.getLeaveAllocation() !=null) {
			booleanBuilder.and(QUser.user.leaveRequest.any().leave.allocation.eq(userCriteria.getLeaveAllocation()));
		}
		if(userCriteria.getLeaveName() !=null) {
			booleanBuilder.and(QUser.user.leaveRequest.any().leave.leaveName.containsIgnoreCase(userCriteria.getLeaveName()));
		}
		if(userCriteria.getTelephone() != null) {
			booleanBuilder.and(QUser.user.telephone.containsIgnoreCase(userCriteria.getTelephone()));
		}
		if(userCriteria.getUserName() != null) {
			booleanBuilder.and(QUser.user.name.containsIgnoreCase(userCriteria.getUserName()));
		}
		if(booleanBuilder.hasValue()) {
			userRrpository.findAll(booleanBuilder).forEach(users::add);
		}else {
			users = userRrpository.findAll();
		}
		return users;
	}

	

}
