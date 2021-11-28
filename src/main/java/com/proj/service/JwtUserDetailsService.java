package com.proj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proj.mapper.MemberMapper;
import com.proj.vo.JwtRequest;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	@Autowired
	   private PasswordEncoder passwordEncoder;
	
	@Autowired
		private MemberMapper memberMapper;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("#########################jwtUserDetailService_loadUserByusernamebefore:"+username);
		JwtRequest loginInfo = memberMapper.login(username);
		System.out.println("#########################jwtUserDetailService_loadUserByusername:"+loginInfo.getUsername());
        if (loginInfo.getUsername().equals(username)) {
        	
            //return new User("user_id", "$2a$10$m/enYHaLsCwH2dKMUAtQp.ksGOA6lq7Fd2pnMb4L.yT4GyeAPRPyS",
        	return new User(loginInfo.getUsername(), passwordEncoder.encode(loginInfo.getPassword()),
        		new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
	
	//20211122 이정주 추가
	 void passwordEncode() {
	      // given
	      String rawPassword = "12345678";

	      // when
	      String encodedPassword = passwordEncoder.encode(rawPassword);

	   } 

}
