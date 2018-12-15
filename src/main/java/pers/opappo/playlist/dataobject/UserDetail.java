package pers.opappo.playlist.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by minghli on 2018/12/15.
 */
@Entity
@Data
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userDetailId;

    private Integer userId;

    private String userAlias;

    private String userIcon;

    private String userDescription;
}
