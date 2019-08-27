package group.gamelife.shiro.demo.config;

import group.gamelife.shiro.demo.entity.Role;
import group.gamelife.shiro.demo.service.OperatorService;
import lombok.extern.java.Log;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by xiongyizhou on 2019/8/13 10:36 E-mail: xiongyizhou@powerpms.com
 * customized realm / 自定义的realm
 * @author xiongyizhou
 */
@Log
public class CustomRealm extends AuthorizingRealm {

  CustomRealm(OperatorService operatorService) {
    this.operatorService = operatorService;
  }

  private OperatorService operatorService;

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {

    log.info("----------authentication beginning----------");
    boolean result =
        operatorService.userAuth((String) token.getPrincipal(), (char[]) token.getCredentials());
    log.info("----------authentication check finish----------");
    if (result) {
      return new SimpleAuthenticationInfo(
              token.getPrincipal(), token.getCredentials(), (String) token.getPrincipal());
    }
    return null;
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    SimpleAuthorizationInfo authz = new SimpleAuthorizationInfo(operatorService.getRolesByOperator(principals.getPrimaryPrincipal().toString()).stream().map(Role::getRoleName).collect(Collectors.toSet()));
    Set<String> pset = new HashSet<>();
    pset.add("p1");
    pset.add("p2");
    pset.add("p3");
    authz.setStringPermissions(pset);
    return authz;
  }
}
