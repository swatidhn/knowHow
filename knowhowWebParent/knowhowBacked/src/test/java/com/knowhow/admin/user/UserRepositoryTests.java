package com.knowhow.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.knowhow.common.entity.Role;
import com.knowhow.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired
	private UserRepository repo;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testCreateuserWithTwoRole() {
		User user1 = new User("swati@kumari.com", "swati", "sinha","swati2020");
		Role editor = new Role(13);
		Role admin = new Role(10);
		user1.addRole(editor);
		user1.addRole(admin);
		User saveUser = repo.save(user1);
		assertThat(saveUser.getId()).isGreaterThan(0);

	}

	@Test
	public void testCreateFirstUser() {
		Role roleAdmin = entityManager.find(Role.class, 10);
		User user = new User("motu@motuu.com", "motu", "singh","sk4949");
		user.addRole(roleAdmin);
		User saveUser = repo.save(user);
		assertThat(saveUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListUsers()
	{
		Iterable<User> userList= repo.findAll();
		userList.forEach(user->System.out.println(user));
	}
	@Test
	public void testGetUserById()
	{
		User user= repo.findById(4).get();
		System.out.println(user);
		assertThat(user).isNotNull();
	}
	@Test
	public void testUpdateUserDetails()
	{
		User user= repo.findById(4).get();
		user.setEnabled(true);
		repo.save(user);
	}
	
	@Test
	public void testUpdateUserRoles()
	{
		User userSwati= repo.findById(4).get();
		Role roleEditor= new Role(13);
		userSwati.getRoles().remove(roleEditor);
		repo.save(userSwati);
	}
@Test

public void testDeleteUser()
{
	Integer userId=2;
	repo.deleteById(userId);
}
	

}
