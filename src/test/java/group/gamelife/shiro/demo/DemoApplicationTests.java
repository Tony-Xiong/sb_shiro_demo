package group.gamelife.shiro.demo;

import group.gamelife.shiro.demo.entity.Operator;
import group.gamelife.shiro.demo.repository.OperatorRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class DemoApplicationTests {

  @Autowired private OperatorRepository repository;

  @Test
  public void contextLoads() {

    Optional<Operator> result = repository.findById("id000001");
    if (result.isPresent()) {
      log.info("导入成功 对象存在");
    } else {
      log.info("导入不成功 对象不存在");
    }
  }
}
