package com.demo.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	/*
	// find userdata from database -> wrap in UserDetailsService => User
	//
	// Customer cus = repo.findById(name);
	// new User(cus.getEmail(), cus.getPassword(), roles)
	//  
	*/
	
//	@Autowired
//	private CustomerRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Customer cus = repo.findById(username);
//		return new User(cus.getUsername(), cus.getPassword(), null);
		if("admin".equals(username)) {
			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	        authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));

//			return new User("admin", "{noop}admin@123", authorities);
//			return new User("admin", "{bcrypt}$2a$10$O0p8Te2oeuuE.J4ffXlsJ.NFlK2R7b708JJxh8fsfTZ6Ih42bAKA6", authorities);
			return new User("admin", "$2a$10$O0p8Te2oeuuE.J4ffXlsJ.NFlK2R7b708JJxh8fsfTZ6Ih42bAKA6", authorities);
		} else if("user".equals(username)) {
			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	        authorities.add(new SimpleGrantedAuthority("ROLE_" + "USER"));

//			return new User("user", "{noop}user@123", authorities);
//			return new User("user", "{bcrypt}$2a$10$If6ruH50YIVzxX9GYuaV7OPdhiluYotwYPrGgfQ7BPtzDvqUVK6iy", authorities);
			return new User("user", "$2a$10$If6ruH50YIVzxX9GYuaV7OPdhiluYotwYPrGgfQ7BPtzDvqUVK6iy", authorities);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
