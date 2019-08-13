package group.gamelife.shiro.demo.web;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiongyizhou on 2019/8/13 13:22
 * E-mail: xiongyizhou@powerpms.com
 *
 * @author xiongyizhou
 */
@RestController
public class WebResource {

    @GetMapping("/index")
    public String index(HttpServletResponse response) throws IOException {

    if (SecurityUtils.getSubject().isAuthenticated()) {

      return "<!DOCTYPE html>\n"
          + "<html lang=\"en\">\n"
          + "<head>\n"
          + "    <meta charset=\"UTF-8\">\n"
          + "    <title>Index</title>\n"
          + "</head>\n"
          + "<body>\n"
          + "<h1>welcome</h1>\n"
          + "<h2>you are already login the system!</h2>\n"
          + "<h3>Good!</h3>\n" + "<h4>"+SecurityUtils.getSubject().getPrincipal().toString()+"</h4>\n"
          + "<form action=\"/auth/logout\"></form>\n"
          + "</body>\n"
          + "</html>";
        }
    else {
        response.sendRedirect("/login");
        return "";
    }
    }

    @RequestMapping("/login")
    public String loginPage(){
    return "<!DOCTYPE html>\n"
        + "<html lang=\"en\">\n"
        + "<head>\n"
        + "    <meta charset=\"UTF-8\">\n"
        + "    <title>Login</title>\n"
        + "</head>\n"
        + "<body>\n"
        + "\n"
        + "<form action=\"/auth/login\" method=\"post\">\n"
        + "    <div><p>用户名</p><input name=\"username\" type=\"text\"></div>\n"
        + "    <div><p>密码</p><input name=\"password\" type=\"text\"></div>\n"
        + "    <button type=\"submit\">登陆</button>\n"
        + "</form>\n"
        + "\n"
        + "</body>\n"
        + "</html>";
    }
}
