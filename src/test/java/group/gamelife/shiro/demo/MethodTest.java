package group.gamelife.shiro.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.junit.Test;

/**
 * Created by xiongyizhou on 2019/8/13 10:02
 * E-mail: xiongyizhou@powerpms.com
 *
 * @author xiongyizhou
 */
public class MethodTest {

    @Test
    public void test1(){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        SubjectContext subjectContext = new DefaultSubjectContext();
        defaultSecurityManager.createSubject(subjectContext);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken authenticationToken = new UsernamePasswordToken("username","password");
        subject.login(authenticationToken);
        System.out.println(subject.isAuthenticated());
    }

}
