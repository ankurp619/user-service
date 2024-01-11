package com.ankur.user.service;

import com.ankur.user.model.Department;
import com.ankur.user.model.ResponseTemplateBO;
import com.ankur.user.entity.User;
import com.ankur.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateBO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateBO vo = new ResponseTemplateBO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}
