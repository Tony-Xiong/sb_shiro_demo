package group.gamelife.shiro.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by xiongyizhou on 2019/8/13 10:46 E-mail: xiongyizhou@powerpms.com
 * role entity / 角色实例
 * @author xiongyizhou
 */
@Entity
@Data
public class Role {
  @Id private Integer roleId;
  @Column private String roleName;
}
