package com.soni.rolebaselogin.service;

import com.soni.rolebaselogin.dto.UserDetailDto;
import com.soni.rolebaselogin.model.UserInfo;
import com.soni.rolebaselogin.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repo.findByName(username);
        return userInfo.map(UserDetailDto::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username ));
    }
}
