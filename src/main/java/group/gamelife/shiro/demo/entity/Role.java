package group.gamelife.shiro.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by xiongyizhou on 2019/8/13 10:46
 * E-mail: xiongyizhou@powerpms.com
 *
 * @author xiongyizhou
 */
@Entity
public class Role {
    @Id private Integer roleId;
    @Column private String roleName;
}
