package com.knowhow.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.knowhow.common.entity.Role;

import antlr.collections.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
@Rollback(false)

public class RoleRepositoryTests {
	@Autowired
	private RoleRepository repo;
	@Test
	public void testCreateFirstRole()
	{
		Role roleAdmin= new Role("Admin","manageEverything");
		Role savedRole= repo.save(roleAdmin);
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void createRole()
	{
		Role rolestudent=new Role("Student","The Learner");
		Role savedRole= repo.save(rolestudent);
		assertThat(savedRole.getId()).isGreaterThan(0);
		
		Role roleteacher=new Role("Teacher","CanUploadContent");
		Role savedRole1= repo.save(roleteacher);
		assertThat(savedRole1.getId()).isGreaterThan(0);
		
		Role roleEditor=new Role("Editor","WriteContentBlog");
		Role savedRole11= repo.save(roleEditor);
		assertThat(savedRole11.getId()).isGreaterThan(0);
		
		Role roleManager=new Role("Manager","Manages Batches and Students data");
		Role savedRole111= repo.save(roleManager);
		assertThat(savedRole111.getId()).isGreaterThan(0);
		
		Role Assistant= new Role("Assistant","Manages Queries and Reviews");
		Role savedRole112= repo.save(Assistant);
		assertThat(savedRole112.getId()).isGreaterThan(0);
	}
	

}
