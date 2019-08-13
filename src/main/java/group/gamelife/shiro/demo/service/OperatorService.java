package group.gamelife.shiro.demo.service;

import group.gamelife.shiro.demo.entity.Operator;
import group.gamelife.shiro.demo.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiongyizhou on 2019/8/13 11:03
 * E-mail: xiongyizhou@powerpms.com
 *
 * @author xiongyizhou
 */
@Service
public class OperatorService {

    private final OperatorRepository repository;

    @Autowired
    public OperatorService(OperatorRepository repository) {
        this.repository = repository;
    }

    public boolean userAuth(String username, String password){
        Operator op = repository.findOperatorByName(username);
        return op.getPassword().equals(password);
    }

}
