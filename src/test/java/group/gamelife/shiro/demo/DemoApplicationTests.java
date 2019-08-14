package group.gamelife.shiro.demo;

import group.gamelife.shiro.demo.entity.Operator;
import group.gamelife.shiro.demo.entity.Role;
import group.gamelife.shiro.demo.repository.OperatorRepository;
import group.gamelife.shiro.demo.repository.RoleRepository;
import lombok.extern.java.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class DemoApplicationTests {

    @Autowired
    private OperatorRepository repository;

    @Test
    public void contextLoads() {

        Optional<Operator> result = repository.findById("id000001");
    if (result.isPresent()) {
      log.info("导入成功 对象存在");
        }
    else
    {
        log.info("导入不成功 对象不存在");
    }
    }

}
