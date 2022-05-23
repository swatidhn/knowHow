package com.knowhow.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowhow.common.entity.Role;
import com.knowhow.common.entity.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private RoleRepository roleRepo;

	public List<User> listAll() {
		return (List<User>) userrepo.findAll();
	}

	public List<Role> listRoles() {

		return (List<Role>) roleRepo.findAll();

	}

	public void save(User user) {
		userrepo.save(user);
		
	}

}
