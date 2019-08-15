package group.gamelife.shiro.demo.web;

import group.gamelife.shiro.demo.entity.Role;
import group.gamelife.shiro.demo.service.OperatorService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Created by xiongyizhou on 2019/8/13 13:22 E-mail: xiongyizhou@powerpms.com
 * login page and index page / 主页和登录页
 * @author xiongyizhou
 */
@RestController
public class WebResource {

  @Autowired private OperatorService operatorService;

  @GetMapping("")
  public void defaultPage(HttpServletResponse response) throws IOException {
    response.sendRedirect("/index");
  }

  @GetMapping("/index")
  public String index(HttpServletResponse response) throws IOException {

    if (SecurityUtils.getSubject().isAuthenticated()) {

      String principal = SecurityUtils.getSubject().getPrincipal().toString();
      Set<Role> roles = operatorService.getRolesByOperator(principal);

      return "<!DOCTYPE html>\n"
          + "<html lang=\"en\">\n"
          + "<head>\n"
          + "    <meta charset=\"UTF-8\">\n"
          + "    <title>Index</title>\n"
          + "</head>\n"
          + "<body>\n"
          + "<h1>welcome</h1>\n"
          + "<h2>you are already login the system!</h2>\n"
          + "<h3>Good!</h3>\n"
          + "<h4>"
          + "username:"
          + principal
          + "</h4>\n"
          + "<p>"
          + roles
          + "</p>"
          + "<form action=\"/auth/logout\" method=\"post\">\n"
          + "    <button type=\"submit\" >logout</button>\n"
          + "</form>"
          + "</body>\n"
          + "</html>";
    } else {
      response.sendRedirect("/login");
      return "";
    }
  }

  @RequestMapping("/login")
  public String loginPage() {
    return "<!DOCTYPE html>\n"
        + "<html lang=\"en\">\n"
        + "<head>\n"
        + "    <meta charset=\"UTF-8\">\n"
        + "    <title>Login</title>\n"
        + "</head>\n"
        + "<body>\n"
        + "\n"
        + "<h1>Login Page</h1>\n"
        + "<h3> default admin account: admin/admin </h3>"
        + "<h3> default user account: user1/123456 </h3>"
        + "<form action=\"/auth/login\" method=\"post\">\n"
        + "    <div><p>username</p><input name=\"username\" type=\"text\"></div>\n"
        + "    <div><p>password</p><input name=\"password\" type=\"text\"></div>\n"
        + "    <button type=\"submit\">login</button>\n"
        + "</form>\n"
        + "\n"
        + "</body>\n"
        + "</html>";
  }
}
