package group.gamelife.shiro.demo.config;

import group.gamelife.shiro.demo.service.OperatorService;
import lombok.extern.java.Log;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * Created by xiongyizhou on 2019/8/13 10:36 E-mail: xiongyizhou@powerpms.com
 * customized realm / 自定义的realm
 * @author xiongyizhou
 */
@Log
public class CustomRealm extends AuthenticatingRealm {

  CustomRealm(OperatorService operatorService) {
    this.operatorService = operatorService;
  }

  private OperatorService operatorService;

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {

    log.info("----------authentication beginning----------");
    boolean result =
        operatorService.userAuth((String) token.getPrincipal(), (char[]) token.getCredentials());
    log.info("----------authentication check finish----------");
    if (result) {
      return new SimpleAuthenticationInfo(
          token.getPrincipal(), token.getCredentials(), (String) token.getPrincipal());
    }
    // return new
    // SimpleAuthenticationInfo(token.getPrincipal(),token.getCredentials(),"withoutAuth");
    return null;
  }
}
