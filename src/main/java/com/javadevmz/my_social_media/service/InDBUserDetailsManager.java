package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.converter.UserDetailsUserConverter;
import com.javadevmz.my_social_media.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InDBUserDetailsManager implements UserDetailsService {

    @Autowired
    private UserDetailsUserConverter userDetailsUserConverter;
    @Autowired
    private UserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userManager.getUserByUsername(username);
        return userDetailsUserConverter.convertUserToUserDetails(user);
    }

}
