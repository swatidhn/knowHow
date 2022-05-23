package com.knowhow.admin.user;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class PasswordEncoderTests {
	@Test
	public void testEncodePassword()
	{
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		String rawpassword="nam2020";
		String encodedPassword=passwordEncoder.encode(rawpassword);
		boolean matches=passwordEncoder.matches(rawpassword, encodedPassword);
		assertThat(matches).isTrue();
		
	}

}
