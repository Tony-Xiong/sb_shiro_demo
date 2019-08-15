package group.gamelife.shiro.demo.repository;

import group.gamelife.shiro.demo.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiongyizhou on 2019/8/13 10:58 E-mail: xiongyizhou@powerpms.com
 * operator repository / 账号的repository层
 * @author xiongyizhou
 */
public interface OperatorRepository extends JpaRepository<Operator, String> {

  Operator findOperatorByName(String name);
}
