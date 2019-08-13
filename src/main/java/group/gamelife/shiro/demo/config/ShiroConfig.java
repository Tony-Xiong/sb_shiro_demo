package group.gamelife.shiro.demo.config;

import group.gamelife.shiro.demo.service.OperatorService;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xiongyizhou on 2019/8/13 10:38
 * E-mail: xiongyizhou@powerpms.com
 *
 * @author xiongyizhou
 */
@Configuration
public class ShiroConfig {

    private final OperatorService operatorService;

    @Autowired
    public ShiroConfig(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @Bean
    public AuthenticatingRealm customRealm(){
        return new CustomRealm(operatorService);
    }

}
