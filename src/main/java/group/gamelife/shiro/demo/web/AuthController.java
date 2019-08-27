package group.gamelife.shiro.demo.web;

import lombok.extern.java.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiongyizhou on 2019/8/13 13:21 E-mail: xiongyizhou@powerpms.com
 * login logout web API / 登陆和登出的web接口
 * @author xiongyizhou
 */
@RestController
@RequestMapping("auth")
@Log
public class AuthController {

  @PostMapping("login")
  public void login(HttpServletResponse response, String username, String password)
      throws IOException {

    log.info("auth/login");

    AuthenticationToken token = new UsernamePasswordToken(username, password);

    try {
      SecurityUtils.getSubject().login(token);
    } catch (AuthenticationException e) {
      log.warning(e.getMessage());
    }

    response.sendRedirect("/index");
  }

  @PostMapping("logout")
  public void logout(HttpServletResponse response) throws IOException {
    SecurityUtils.getSubject().logout();
    response.sendRedirect("/login");
  }
}
