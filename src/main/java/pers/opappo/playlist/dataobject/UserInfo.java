package pers.opappo.playlist.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import pers.opappo.playlist.enums.UserStatusEnum;
import pers.opappo.playlist.enums.UserTypeEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户信息表映射对象
 * Created by minghli on 2018/9/27.
 */
@Entity
@Data
@DynamicUpdate
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String username;

    private String password;

    //用户状态默认0正常
    private Integer userStatus = UserStatusEnum.NORMAL.getCode();

    private Integer userType = UserTypeEnum.NORMAL.getCode();

    private Date createTime;

    private Date visitedTime;

    private Integer visitedCount;
}
