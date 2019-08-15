package group.gamelife.shiro.demo.service;

import group.gamelife.shiro.demo.entity.Operator;
import group.gamelife.shiro.demo.entity.Role;
import group.gamelife.shiro.demo.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by xiongyizhou on 2019/8/13 11:03 E-mail: xiongyizhou@powerpms.com
 * operator service / 服务层
 * @author xiongyizhou
 */
@Service
public class OperatorService {

  private final OperatorRepository repository;

  @Autowired
  public OperatorService(OperatorRepository repository) {
    this.repository = repository;
  }

  public boolean userAuth(String username, char[] password) {
    Operator op = repository.findOperatorByName(username);
    if (op == null) {
      return false;
    }
    return Arrays.equals(op.getPassword().toCharArray(), password);
  }

  public Set<Role> getRolesByOperator(String name) {
    Operator operator = repository.findOperatorByName(name);
    return operator.getRoles();
  }
}
