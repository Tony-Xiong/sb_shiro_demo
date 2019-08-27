package group.gamelife.shiro.demo.config;

import group.gamelife.shiro.demo.service.OperatorService;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xiongyizhou on 2019/8/13 10:38 E-mail: xiongyizhou@powerpms.com
 * shiro configuration
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
  public AuthenticatingRealm customRealm() {
    return new CustomRealm(operatorService);
  }

  @Bean
  public DefaultWebSecurityManager securityManager() {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(customRealm());
    return securityManager;
  }

  @Bean
  public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    shiroFilterFactoryBean.setSecurityManager(securityManager);
    shiroFilterFactoryBean.setLoginUrl("/login");
    shiroFilterFactoryBean.setSuccessUrl("/index");
    shiroFilterFactoryBean.setUnauthorizedUrl("/login");

    Map<String, String> map = new LinkedHashMap<>();
    map.put("/static/**", "anon");
    map.put("/login", "anon");
    map.put("/auth/**", "anon");
    map.put("/favicon.ico", "anon");
    map.put("/h2", "anon");
    map.put("/h2/**", "anon");
    map.put("/**", "authc");
    shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

    return shiroFilterFactoryBean;
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
    advisor.setSecurityManager(securityManager);
    return advisor;
  }

}
