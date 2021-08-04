package com.example.uerinfo;

import com.example.uerinfo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UerInfoApplicationTests {

    @Autowired
    private UserMapper usermappr;

    @Test
    void contextLoads() {
        System.out.println(usermappr.findAll());
    }

}
