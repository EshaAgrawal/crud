//package com.springbootcrudexample.service;
//
//
//import java.util.ArrayList;
//
//import com.springbootcrudexample.dao.UserDao;
//import com.springbootcrudexample.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//    public class JwtUserDetailsService {
//
//        @Autowired
//        private UserDao userDao;
//
//        @Autowired
//        private PasswordEncoder bcryptEncoder;
//
//        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//            if ("abc".equals(username)) {
//                return new User("abc", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//                        new ArrayList<>());
//            } else {
//                throw new UsernameNotFoundException("User not found with username: " + username);
//            }
//        }
//
//        public UserDao save(User user) {
//            User newUser = new User();
//            newUser.setUsername(user.getUsername());
//            newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//            return userDao.save(newUser);
//        }
//
//    }
//}
